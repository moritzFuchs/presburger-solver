package BA.Server;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import BA.util.GraphViz;

public class ImageJSONWorker extends Thread{

	private SolverRequest s;
	
	public ImageJSONWorker(SolverRequest s){
		this.s = s;
	}
	
	public void run() {
		//Write Image File
		String name = "static/tmp/" + ((Long)System.currentTimeMillis()).toString()  + s.getSession() + s.getClientId() + ".gif";
		File out = new File(name);
		GraphViz gv = new GraphViz();
	    gv.writeGraphToFile( gv.getGraph( s.getAutomaton(), "gif" ), out );
	    s.setImageName(name.substring(7));
	    
	    
	    //Write Text-File for export-Button
	    name = "static/tmp/" + ((Long)System.currentTimeMillis()).toString()  + s.getSession() + s.getClientId() + ".txt";
		out = new File(name);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(out);
			DataOutputStream dos = new DataOutputStream(fos);
			
			String json = 
			"{\"status\": \"Done\", \"id\": " + s.getId() + 
			", \"clientId\" : " + s.getClientId() + 
			", \"solutionAut\" : \"" + escape(s.getAutomaton()) + 
			"\", \"absSol\": \"" + s.getNumberOfSolutions() + 
			"\"," + s.getJSONSolutionSpace() +
			", \"type\": \"" + s.getSolType() +
			"\"}";
			
			dos.writeChars(json);
			dos.close();
		    s.setExportName(name.substring(7));
		} catch (FileNotFoundException e) {
			System.err.println("Exportfile could not be written.");
		} catch (IOException e) {
			System.err.println("Exportfile could not be written.");
		}
		

	    s.setDone(true);
	}
	
	private String escape(String x) {
		return x.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "*");
	}
	
}
