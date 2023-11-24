package cms.cm;

import java.lang.reflect.Method;

public class Exemple2 {
	
	public static void main (String[] args) throws Exception {
		Allocataire a = new Allocataire ("Tartampion");
		Personne p = new Personne ("Dummy");
		a.montantAllocs = 100;
		System.out.println(a.getNom());
		System.out.println(((Personne)a).getNom());
		Method m = p.getClass().getMethod("getNom", null);
		System.out.println(m.invoke(a, null));
	}

}
