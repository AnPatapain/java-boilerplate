package cms.cmConcurrence;

public class SynchAvecArret{  
	
	public static void main(String args[]){  
		AfficheTable tab = new AfficheTableAvecArret();  
		Runnable r1 = new RunnableTable1(tab);  
		Runnable r2 = new RunnableTable2(tab);
		Thread t1 = new Thread(r1);
		t1.setPriority(1);
		Thread t2 = new Thread(r2);
		t2.setPriority(10);
		t1.start();  
		t2.start();
	}
	
}  