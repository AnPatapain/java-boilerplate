package cms.cm;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	
	public static void main(String[] args) {
		
	      LinkedList listeChainee = new LinkedList();
	      listeChainee.add("element 1");
	      listeChainee.add("element 2");
	      listeChainee.add("element 3");
	      listeChainee.remove(1);
	      Iterator iterator = listeChainee.iterator();
	      while (iterator.hasNext()) {
	            System.out.println("objet = "+iterator.next());
	      }
	}

}
