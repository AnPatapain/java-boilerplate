package examenExemple.additionChiffres;

public class MainConcatener {

	public static String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
	
	public static void main(String[] args) {
		Concatener c = new Concatener();
		String[] entree = new String[1000];
		for(int i = 0;i<1000; i++)
			entree[i]=Integer.toString(i);
		for(String s : entree) {
			c.plus(s+"--");
		}
		System.out.println("Valeur : "+c.getValeur());
	}
}
