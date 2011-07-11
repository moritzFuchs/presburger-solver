package BA.Server;


import java.util.LinkedList;

import BA.Solver.PresburgerSolver;
import BA.Solver.Exceptions.InvalidFormulaException;
import BA.Solver.Exceptions.TooManyVariablesException;

public class Worker extends Thread{

	private LinkedList<SolverRequest> queue;
	private WorkerController wc;
	
	public SolverRequest current;
	
	private boolean killed = false;
	
	//TODO: Put this in an external ini file. 
	private PresburgerSolver solver = new PresburgerSolver(15);
	
	
	public Worker(LinkedList<SolverRequest> queue , WorkerController wc) {
		this.queue = queue;
		this.wc = wc;
	}
	
	public synchronized SolverRequest getRequest() {
		return queue.removeFirst();
	}
	
	public void kill() {
		killed = true;
	}
	
	/**
	 * Takes Request and handles them.
	 */
	public void run() {
		while (!killed) {
			while (!queue.isEmpty()) {		
				SolverRequest s = getRequest();
				current = s;
				try {
					solver.solve(s);
				} catch (TooManyVariablesException e) {
					s.setException(e.getMessage());
				} catch (InvalidFormulaException e) {
					s.setException("Sorry, your formula was in a invalid format.");
				} catch (Exception e) {
					e.printStackTrace();
					s.setException("An unknown error occured.");
				}
				if (killed)
					return;
				wc.report();
				//Make the Image and Export-Files
				ImageJSONWorker i = new ImageJSONWorker(s);
				i.start();
			}
			wc.report();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println("I can't get no sleep.");
			}
		}
		
	}	
}
