package cms.cmConcurrence;

public class ExempleJoinThread {
	
	public static void main(String[] args)
			throws InterruptedException {
		Thread t0 = new CompteARebours(10);
		Thread t1 = new CompteARebours(2);
		t0.start();
		t1.start();
		System.out.println("Exécution du join. T0 : "+t0.isAlive()+" T1 : "+t1.isAlive());
		t1.join();
		System.out.println("Join terminé. T0 : "+t0.isAlive()+" T1 : "+t1.isAlive());
	}

}
