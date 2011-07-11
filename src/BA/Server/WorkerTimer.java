package BA.Server;

public class WorkerTimer extends Thread{

	private Thread t;
	
	public WorkerTimer(Thread t) {
		this.t = t;
	}
	
	public void run() {
		try {
			Thread.sleep(30000);
			t.interrupt();
		} catch (InterruptedException e) {
			
		}
	}
	
}
