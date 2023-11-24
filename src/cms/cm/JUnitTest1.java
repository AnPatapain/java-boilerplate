package cms.cm;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class JUnitTest1 extends TestCase {

   String nom = "Alice";	
   PrintExemple printer = new PrintExemple(nom);
   
   @Test
   public void testPrint() {	
      System.out.println("On est dans testPrint()");    
      assertEquals(nom, printer.print());     
   }
}