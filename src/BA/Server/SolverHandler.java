package BA.Server;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.antlr.runtime.RecognitionException;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import BA.Solver.FormulaTester;
import BA.Solver.Macro;
import BA.Solver.MacroManager;

public class SolverHandler extends AbstractHandler{

	private int id = 0;
	private LinkedList<SolverRequest> q = new LinkedList<SolverRequest>();
	private HashMap<Integer,SolverRequest> requests = new HashMap<Integer,SolverRequest>();
	
	private Worker w;
	private WorkerController wc;
	private TmpCleaner t;
	
	public SolverHandler() {
		wc = new WorkerController(this);
		wc.start();
		w = new Worker(q,wc);
		w.start();
		t = new TmpCleaner();
		t.start();
	}
	
	public void resetWorker() {
		System.out.println("Resetting Worker.");
		w.kill();
		if (w.current != null)
			w.current.setTimeout(true);
		w  = new Worker(q,wc);
		w.start();
	}
	
	public void handle(String target, 
			Request baseRequest, 
			HttpServletRequest request, 
			HttpServletResponse response)  throws IOException, ServletException {
		
		if (request.getParameter("request").compareTo("test") == 0) {
			testFormula(baseRequest, request, response);
			return;
		}
		
		if (request.getParameter("request").compareTo("testMacro") == 0) {
			testMacro(baseRequest, request, response);
			return;
		}
		
		if (request.getParameter("request").compareTo("clearMacros") == 0) {
			clearMacros(baseRequest, request, response);
			return;
		}
		
		if (request.getParameter("request").compareTo("addMacro") == 0) {
			addMacro(baseRequest, request, response);
			return;
		}
		
		if (request.getParameter("request").compareTo("getMacros") == 0) {
			getMacros(baseRequest, request, response);
			return;
		}
		
		if (request.getParameter("request").compareTo("new") == 0) {

			System.out.println("Request from Session ID " + request.getSession().getId());
			
			SolverRequest s = new SolverRequest(this.id, request.getParameter("equation"),Integer.valueOf(request.getParameter("clientId")) ,request.getSession().getId() ); 
			s.setId(this.id);
			s.setEquation(request.getParameter("equation"));
			s.setClientId(Integer.valueOf(request.getParameter("clientId")));
			s.setSessionId(request.getSession().getId());
			s.setSolType(request.getParameter("solType"));
			s.setNumSol(Integer.valueOf(request.getParameter("numSol")));
			s.setSolTerm(request.getParameter("term"));
			s.setMacroManager((MacroManager)request.getSession().getAttribute("MacroManager"));
			
			this.id++;
			
			q.addLast(s);
			requests.put(s.getId(),s);
			
			response.setContentType("text/html;charset=utf-8");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			response.getWriter().println("{\"status\": \"OK\", \"id\": " + s.getId() + ",\"Queue\":" + q.indexOf(s) + ", \"clientId\" : " + s.getClientId() + "}");
			response.flushBuffer();
				
		} else {
			
			if (request.getParameter("request").compareTo("status") == 0) {
				if (request.getParameter("id") == null)
					return;
				Integer id = Integer.valueOf(request.getParameter("id"));
				SolverRequest s = requests.get(id);
				if (s == null) {
					response.setContentType("text/html;charset=utf-8");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					response.getWriter().println("{\"status\": \"NIL\"}");
					return;
				}
				
				if (s.getSession().compareTo(request.getSession().getId()) == 0)  {
					if (s.isDone()) {
						response.setContentType("text/html;charset=utf-8");
						response.setStatus(HttpServletResponse.SC_OK);
						baseRequest.setHandled(true);
						if (s.getException().equals("")) {
							response.getWriter().println(
									"{\"status\": \"Done\", \"id\": " + s.getId() + 
									", \"clientId\" : " + s.getClientId() + 
									", \"url\" : \"" + s.getImageName() +
									"\", \"export\" : \"" + s.getExportName() +
									"\", \"solutionAut\" : \"" + escape(s.getAutomaton()) + 
									"\", \"absSol\": \"" + s.getNumberOfSolutions()+ 
									"\"," + s.getJSONSolutionSpace()+
									", \"type\": \"" + s.getSolType()+
									"\"}");
							
						} else {
							 
							
							String append = "";
							if (!s.getImageName().equals("")) {
								append += ", \"url\" : \"" + s.getImageName() + "\""; 
							}
							
							if (!s.getAutomaton().equals("")) {
								append += ", \"solutionAut\" : \"" + escape(s.getAutomaton()) + "\""; 
							}
							
							
							response.getWriter().println(
									"{\"status\": \"Error\", \"id\": " + s.getId() + 
									", \"clientId\" : " + s.getClientId() + 
									", \"desc\" : \"" + s.getException() + 
									"\"" + append + "}");
						}
						
						requests.remove(s.getId());
						
					} else {
					
						if (!s.getException().equals("")) {
							response.setContentType("text/html;charset=utf-8");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							response.getWriter().println("{\"status\": \"Error\", \"id\": " + s.getId() + ", \"clientId\" : " + s.getClientId() + ", \"desc\" : \"" + s.getException() + "\"}");
							return;
						} 
						
						if (s.getTimeout()) {
							response.setContentType("text/html;charset=utf-8");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							response.getWriter().println("{\"status\": \"Timeout\", \"id\": " + s.getId() + ", \"clientId\" : " + s.getClientId() + "}");
							return;
						} 
						
						if (q.contains(s)) {
							response.setContentType("text/html;charset=utf-8");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							response.getWriter().println("{\"status\": \"Queue\", \"id\": " + s.getId() + ",\"Queue\":" + q.indexOf(s) + ", \"clientId\" : " + s.getClientId() + "}");
						} else {
							response.setContentType("text/html;charset=utf-8");
							response.setStatus(HttpServletResponse.SC_OK);
							baseRequest.setHandled(true);
							response.getWriter().println("{\"status\": \"Working\", \"id\": " + s.getId() + ", \"clientId\" : " + s.getClientId() + "}");
						}
					}
					
					
				} else {
					//Not the guys request!
					response.setContentType("text/html;charset=utf-8");
					response.setStatus(HttpServletResponse.SC_OK);
					baseRequest.setHandled(true);
					response.getWriter().println("{\"status\": \"IDMismatch\", \"id\": " + s.getId() + "}");
				}
			}
		}
	}

	private void testFormula(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		
		baseRequest.setHandled(true);
		int errorFormula = FormulaTester.testInput(request.getParameter("equation"));
		int errorRest = -1;
		if (request.getParameter("solType").equals("Min") || request.getParameter("solType").equals("Max") ) {
			errorRest = FormulaTester.testInput(request.getParameter("term") + "== 0");
		}
		
		if (errorFormula == -1 && errorRest == -1) {
			response.getWriter().println("{\"valid\": true,\"equation\": \"" + realEscape(request.getParameter("equation")) + "\", \"clientId\": " + request.getParameter("clientId") + ", \"solType\": \"" + request.getParameter("solType") + "\", \"numSol\": \"" + request.getParameter("numSol") + "\", \"term\": \"" + request.getParameter("term") + "\"}");
		} else {
			response.getWriter().println("{\"valid\": false,\"equation\": \"" + realEscape(request.getParameter("equation")) + "\", \"clientId\": " + request.getParameter("clientId") + " , \"indexFormula\": " + errorFormula + ", \"indexRest\": " + errorRest + "}");
		}
	}

	
	//Tests whether a macro already exists or not.
	private void testMacro(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		String macro = request.getParameter("macro");
		
		String answer = "";
		
		HttpSession s = request.getSession();
		MacroManager m;
		
		String name = "";
		String[] nameAndArguments = macro.split("\\("); 
		name = nameAndArguments[0];
		
		Character first = name.charAt(0);
		if (!Character.isUpperCase(first)) {
			answer = "{\"exists\": false,\"index\": " + request.getParameter("clientId") + " , \"name\":\"" + name + "\" , \"error\" : \"The first letter of your Macro has to be a upper case letter.\"}";
		} else {
			boolean error = false;
			for (int i=1;i<name.length();i++) {
				if (!Character.isLowerCase(name.charAt(i))) {
					error = true;
					answer = "{\"exists\": false,\"index\": " + request.getParameter("clientId") + " , \"name\":\"" + name + "\" , \"error\" : \"All letters except the first have to be lower case letters.\"}";
				}
					
			}
			if (!error) {
				try {
					 m = (MacroManager) s.getAttribute("MacroManager");
					 if (m == null) {
						 m = new MacroManager();
						s.setAttribute("MacroManager", m);
					 }
				} catch (Exception e) {
					m = new MacroManager();
					s.setAttribute("MacroManager", m);
					answer = "{\"exists\": false,\"index\": " + request.getParameter("clientId") + " , \"name\":\"" + name + "\"}"; 
				}
				
				if (answer.equals("")) {

					if (!m.macroExists(name)) {
						answer = "{\"exists\": false,\"index\": " + request.getParameter("clientId") + " , \"name\":\"" + name + "\"}";
					} else {
						answer = "{\"exists\": true,\"index\": " + request.getParameter("clientId") + " , \"name\":\"" + name + "\"}";
					}
				}
			}
			
			
		}
		
		try {
			response.getWriter().println(answer);
		} catch (IOException e) {
			System.err.println("Couldn't get Writer.");
		}
		
	}
	
	private void addMacro(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		String macro = request.getParameter("macro");
		
		HttpSession s = request.getSession();
		System.out.println("Adding Macro to Session ID " + s.getId());
		MacroManager m;
		try {
			 m = (MacroManager) s.getAttribute("MacroManager");
			 if (m == null) {
				m = new MacroManager();
				s.setAttribute("MacroManager", m);
			 }
		} catch (Exception e) {
			m = new MacroManager();
			s.setAttribute("MacroManager", m);
		}

		String oldIdString = (String)request.getParameter("id");
		Integer oldId = -1;
		if (oldIdString.length() >= 8 && oldIdString.substring(0,7).equals("macroId")) {
			oldId = Integer.valueOf(oldIdString.substring(7,oldIdString.length()));
		}
		
		Integer id = m.exists((String)request.getParameter("macro"));
		String error = "";
		if (id != -1 && id != oldId) {
			error += ",\"delete\" : \"" + id + "\"";
		} else {
			if (oldId != -1)
				error += ",\"listDelete\" : \"" + oldId + "\"";
		}
		Integer nid;
		try {
			nid = m.addMacro((String)request.getParameter("macro"));
			if (oldId != -1 && oldId != nid)
				m.deleteId(oldId);
			if (id != -1 && id!= nid)
				m.deleteId(id);
		} catch (Exception e){
			if (e.getMessage() != null) {				
				response.getWriter().println("{\"valid\": false,\"macro\": \"" + request.getParameter("macro") + "\", \"clientId\": " + request.getParameter("clientId") + 
						",\"error\": \"" + e.getMessage() + "\"}");
			} else {
				response.getWriter().println("{\"valid\": false,\"macro\": \"" + request.getParameter("macro") + "\", \"clientId\": " + request.getParameter("clientId") + 
						",\"error\": \"An unknown Error occured, please click Help me to make sure your macro definition has the right syntax.\"}");
			}
			return;
		}
				
		response.getWriter().println("{\"valid\": true,\"macro\": \"" + request.getParameter("macro") + "\",\"macroId\": \"" + nid + "\", \"clientId\": " + request.getParameter("clientId") + error+"}");
	}
	
	private void getMacros(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		
		HttpSession s = request.getSession(true);

		MacroManager m;
		try {
			 m = (MacroManager) s.getAttribute("MacroManager");
			 if (m == null) {
				m = new MacroManager();
				s.setAttribute("MacroManager", m);
				response.getWriter().println("{\"valid\": false}");
				return;
			 }
		} catch (Exception e) {
			m = new MacroManager();
			s.setAttribute("MacroManager", m);
			response.getWriter().println("{\"valid\": false}");
			return;
		}
		
		String json = "{\"valid\": true,";
		json += "\"macros\": {";
		boolean one =false;
		int i=0;
		for (Macro macro:m.getAllMacros()) {
			one = true;
			json += "\"" + i++ + "\" : {\"macro\" : \"" + macro.getText() +"\", \"id\": \"" + macro.getId() + "\"},";
		}
		if (one)
			json = json.substring(0 , json.length()-1);
		json += "}}";
		response.getWriter().println(json);

	}

	private void clearMacros(Request baseRequest, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		System.out.println("Clearing Macros");
		
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		
		HttpSession s = request.getSession();
		
		MacroManager m;
		try {
			 m = (MacroManager) s.getAttribute("MacroManager");
			 if (m == null) {
				m = new MacroManager();
				s.setAttribute("MacroManager", m);
				response.getWriter().println("{\"valid\": true}");
				return;
			 }
		} catch (Exception e) {
			response.getWriter().println("{\"valid\": true}");
			return;
		}
		
		m.clear();
		response.getWriter().println("{\"valid\": true}");
	}
	
	private String escape(String x) {
		return x.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "*");
	}
	
	private String realEscape(String x) {
		return x.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
	}
	
	
}
