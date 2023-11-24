package cms.cm;

import java.util.Vector;

public class OutOfMemory {
	
	// Params à tester -Xmx256M -Xms10M
	// -Xmx1G -Xms10M
	public static void main(String[] args) {
		// Allouer un table de taille très grand
		int n = 0;
		int m = 0;
		long p = 0;
		Vector<Personne> v = new Vector<Personne>();
		try{
			while(true) {
				v.add(new Personne("P"+p));
				n++;
				p++;
				if(n%1000 == 0) {
					System.out.print(".");
					m++;
					n=0;
				}
				if((m%1000 == 0) && (n==0)) {
					System.out.println(".");
					System.out.println("Mémoire libre :"+Runtime.getRuntime().freeMemory()/1000000+" Mo");
					System.out.println("Mémoire utilisée :"+Runtime.getRuntime().totalMemory()/1000000+" Mo");
					m=0;
				}
			}
		}catch(OutOfMemoryError e) {
			System.err.print("Erreur pour "+p);
			System.err.flush();
		}
	}

}
