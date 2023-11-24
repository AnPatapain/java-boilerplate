package cms.cmConcurrence;

public class AfficheTableAvecArret extends AfficheTable{
	
	private volatile boolean arret = false;
	
	public void printTable(int n){ // ajouter synchronized
		for(int i=0;i<=10;i++){  
			System.out.println(n*i);
			if(this.arret) {
				return;
			}
			try{  
				Thread.sleep(0);  
			}catch(Exception e){System.out.println(e);}
		}  
		this.arret = true;
	}  
	
}  