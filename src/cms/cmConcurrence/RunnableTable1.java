package cms.cmConcurrence;

class RunnableTable1 implements Runnable{  
	AfficheTable t;  
	
	public RunnableTable1(AfficheTable t){  
		this.t=t;  
	}  
	
	public void run(){  
		t.printTable(5);
	}
	
}  