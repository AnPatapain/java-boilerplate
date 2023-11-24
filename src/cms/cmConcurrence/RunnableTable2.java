package cms.cmConcurrence;

class RunnableTable2 implements Runnable{  
	AfficheTable t;  
	
	public RunnableTable2(AfficheTable t){  
		this.t=t;  
	}  
	
	public void run(){  
		t.printTable(100);
	}
	
}  