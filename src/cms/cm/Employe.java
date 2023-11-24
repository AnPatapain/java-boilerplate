package cms.cm;

public class Employe {
	private int numeroEmp;
	private static int nombreEmp = 0;
	private String nom = "";
	private String prenom = "";
	private double salaireMensuel = 0;
	private double primeAnnuelle = 0;
	
	public Employe (String _n, String _p, double _sMensuel, double _pAnnu) {
		this.numeroEmp = Employe.nombreEmp++;
		this.nom = _n;
		this.prenom = _p;
		this.salaireMensuel = _sMensuel;
		this.primeAnnuelle = _pAnnu;
	}

	
}
