package cms.cmConcurrence;


public class Producer extends Thread {
	private Queue q;

	public Producer(Queue q) {
		this.q = q;
	}

	public void run() {
		int i = 0;
		while (!Thread.currentThread().isInterrupted()) {
			try {
				i++;
				q.put("valeur-" + i);
				System.out.println("Producer put : " + i);
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
}