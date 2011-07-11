package BA.Server;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import BA.Solver.MacroManager;

public class SolverRequest {

	private int id = 0;
	private int clientId = 0;
	private String equation = "";
	private String sessionID = "";
	
	private boolean done = false;
	private String exception = "";
	private String solType;
	private String solTerm;
	private Integer numSol = 1;
	private MacroManager m;
	private List<Integer[]> solutionSpace;
	private Integer optimizedSolution;
	private String jsonAutomaton;
	private String automaton;
	private Integer numberOfSolutions;
	private String[] solutionVarNames;
	private String imageName;
	private String exportName;
	private Integer varNum;
	
	private boolean timeout = false;
	
	public SolverRequest(int id, String e, int clientId , String session) {
		this.id = id;
		this.equation = e;
		this.clientId = clientId;
		this.sessionID = session;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setClientId(int id) {
		this.clientId = id;
	}
	
	public void setEquation(String equation) {
		this.equation = equation;
	}
	
	public void setSessionId(String sid) {
		this.sessionID = sid;
	}
	
	public void setSolType(String type) {
		this.solType = type;
	}
	
	public void setNumSol(Integer num) {
		this.numSol = num;
	}
	
	public void setSolTerm(String term) {
		this.solTerm = term;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getClientId() {
		return this.clientId;
	}
	
	public String getEquation() {
		return this.equation;
	}
	
	public String getSession() {
		return this.sessionID;
	}
	
	public String getSolType() {
		return this.solType;
	}
	
	public Integer getNumSol() {
		return this.numSol;
	}
	
	public String getSolTerm() {
		return this.solTerm;
	}
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public boolean isDone() {
		return this.done;
	}
	
	public void setException(String e) {
		this.exception = e;
	}
	
	public String getException() {
		return this.exception;
	}
	
	public void setMacroManager(MacroManager m) {
		this.m = m;
	}
	
	public MacroManager getMacroManager() {
		return this.m;
	}

	public void setSolutionSpace(List<Integer[]> solutions) {
		this.solutionSpace = solutions;
	}
	
	public List<Integer[]> getSolutionSpace() {
		return this.solutionSpace;
	}

	public void setOptimizedSolution(Integer value) {
		this.optimizedSolution = value;
	}
	
	public Integer getOptimizedSolution() {
		return this.optimizedSolution;
	}

	public void setJSONAutomaton(String result) {
		this.jsonAutomaton = result;
	}
	
	public String getJSONAutomaton() {
		return this.jsonAutomaton;
	}
	
	public void setAutomaton(String result) {
		this.automaton = result;
	}
	
	public String getAutomaton() {
		return this.automaton;
	}
	
	public void setNumberOfSolutions(Integer result) {
		this.numberOfSolutions = result;
	}
	
	public Integer getNumberOfSolutions() {
		return this.numberOfSolutions;
	}

	public void setVarNames(String[] varNames) {
		this.solutionVarNames = varNames;
	}
	
	public String[] getVarNames() {
		return this.solutionVarNames;
	}
	
	public String getJSONSolutionSpace() {
		if (solutionSpace != null) {
			
			String jsonSolution = "\"solution\": {";
			if (this.varNum != null)
				jsonSolution += "\"varNum\":" + this.varNum + ",";
	        if (solType.equals("Max") || solType.equals("Min"))
	        	jsonSolution += "\"OptimizedSolution\": \"" + optimizedSolution + "\",";
	        if (numSol != 0) {
	        	jsonSolution += "\"Names\": {";
	        	int i=0;
	        	String[] res = solutionVarNames;
	        	boolean once = false;
	        	for (String s:res) {
	        		once = true;
	        		jsonSolution += "\"" + i + "\" : \"" + s + "\" ,";
	        		i++;
	        	}
	        	if (once)
	        		jsonSolution = jsonSolution.substring(0,jsonSolution.length()-1);
	        	jsonSolution += "},";
	        	
	        	try {
	        		JSONArray test = new JSONArray(solutionSpace.toArray());
	        		String add = "\"Solutions\": ";
	        		add += test.toString();
	        		jsonSolution += add;
				} catch (JSONException e) {
					jsonSolution.substring(0 , jsonSolution.length()-1);
				}
	        	
	        }
	        
	    	jsonSolution += "}";
	    	
	    	return jsonSolution;
		}
		return "\"solution\":{}";
	}

	public void setImageName(String name) {
		this.imageName = name;
	}
	
	public String getImageName() {
		return this.imageName;
	}

	public void setVarNum(Integer countVariables) {
		this.varNum = countVariables;
	}
	
	public Integer getVarNum(Integer countVariables) {
		return this.varNum;
	}

	public void setExportName(String name) {
		this.exportName = name;
	}
	
	public String getExportName() {
		return this.exportName;
	}
	
	public void setTimeout(boolean b) {
		this.timeout = b;
	}
	
	public boolean getTimeout() {
		return this.timeout;
	}
}
