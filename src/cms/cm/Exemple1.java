package cms.cm;

public class Exemple1 {
	public static void main(String[]args) {
		Personne p = new Personne ("Tartempion");
		String s="";
		s = p.getNom();
		System.out.println(s);
		System.out.println(p.getNom());
		//System.out.println(p.nom); // erreur
	}

}
