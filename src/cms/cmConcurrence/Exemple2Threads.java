package cms.cmConcurrence;

public class Exemple2Threads {

	  public static void main(String[] args) {
		  	Runnable r = new CompteurSync();
		    Thread t1 = new Thread(r);
		    Thread t2 = new Thread(r);
		    t1.start();
		    t2.start();
		  }
	
}
