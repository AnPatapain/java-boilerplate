package cms.cmConcurrence;

public class ExempleThread {

	public static void main(String[] args) {
		Thread t = new Thread(new Compteur());
		System.out.println(t.getName());
		System.out.println(t);
		t.start();
		/*
		 * On peut aussi écrire de la manière suivante
		 */
		//Runnable r = new Compteur();
		//Thread th = new Thread(r);
		//th.start();

	}

}