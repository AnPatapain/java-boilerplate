package cms.cmConcurrence;


public class Consumer extends Thread {
	private Queue q;

	public Consumer(Queue q) {
		this.q = q;
	}

	public void run() {
		String value = null;
		while (!Thread.currentThread().isInterrupted()) {
			try {
				System.out.println("Consumer tente de get ...");
				value = q.get();
				System.out.println("Consumer get reçu : " + value);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}