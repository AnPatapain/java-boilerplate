package cms.cm;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class JUnitTest2 { // mettre éventuellement extends TestCase

   String nom = "Alice";	
   PrintExemple printer = new PrintExemple(nom);
 
   @BeforeClass
   public static void beforeClass() {
	   System.out.println("Avant Classe !");
   }
   
   @Before
   public void avant() {
	   System.out.println("Avant !");
   }
   
   @After
   public void apres() {
	   System.out.println("Après !");
   }
   
   @Test
   public void testSalutMessage1() {
      System.out.println("On est dans test salut message 1");
      nom = "Salut " + "Alice";
      assertEquals(nom,printer.printSalut());
   }
   
   @Test
   public void testSalutMessage2() {
      System.out.println("On est dans test salut message 2");
      nom = "Salut " + "Bob";
      assertTrue(nom.equals(printer.printSalut()));
   }
   

}