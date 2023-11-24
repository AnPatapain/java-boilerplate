package cms.cmConcurrence;

public class ExempleThreadGrandCompteur {
	
	public static void main(String[] args) {
		Runnable r = new GrandCompteur(100, 3);
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
	}
	
}
