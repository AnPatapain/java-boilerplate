package cms.cmConcurrence;

public class AfficheTable{
	

	
	public void printTable(int n){ // ajouter synchronized
		for(int i=0;i<=10;i++){  
			System.out.println(n*i);  
			try{  
				Thread.sleep(200);  
			}catch(Exception e){System.out.println(e);}
		}  
	}  
	
}  