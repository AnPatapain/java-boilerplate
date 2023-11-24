package cms.cmConcurrence;

public class CompteurSync implements Runnable {
	
	public void run() {
		this.operation();
	}
	
	public synchronized void operation() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i+"--");
		}
		System.out.println();
	}
	
}