package cms.cmConcurrence;

public class Synch{  
	
	public static void main(String args[]){  
		AfficheTable tab = new AfficheTable(); 
		Runnable r1 = new RunnableTable1(tab);  
		Runnable r2 = new RunnableTable2(tab);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();  
		t2.start();  
	}
	
}  