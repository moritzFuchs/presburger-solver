package BA.Server;

import java.io.File;


public class TmpCleaner extends Thread{

	/**
	 * Cleanes the tmp-directoy every 10 Minutes
	 */
	public void run() {
		
		while (true) {
			System.out.println("Cleaning tmp directory");
			File dir = new File("static/tmp/");
		   if (dir.isDirectory()) {
		       String[] children = dir.list();
		       for (int i = 0; i < children.length; i++) {
		           File x = new File(dir, children[i]);
		           String name = x.getName();
		           if (!name.substring(0, 1).equals(".")) {
			           Long time = Long.valueOf(name.substring(0, 13));
			           if (time + 1800000 < System.currentTimeMillis()) {
			        	   x.delete();
			           }
		           }
		       }
		   }
		   
		 try {
			Thread.sleep(600000);
		} catch (InterruptedException e) {
			System.err.println("I can't get no sleep.");
		}
		}
	}
	
}