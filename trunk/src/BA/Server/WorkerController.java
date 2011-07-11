package BA.Server;

public class WorkerController extends Thread {

	SolverHandler s;
	Boolean reported = true;
	
	public WorkerController(SolverHandler s) {
		this.s = s;
	}
	
	public void report() {
		reported = true;
	} 
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Checking Worker activity: " + reported);
			if (!reported)
				s.resetWorker();
			
			reported = false;
		}
	}
}
