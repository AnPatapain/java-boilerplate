package cms.cm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestPersonne {
	
   int anneeNaiss = 1990;	
   int moisNaiss = 0;
   Personne p = null;


   
   @Test
   public void testddn() {
	   // Initialisation
	   Calendar ddn = new GregorianCalendar(anneeNaiss,1,1);
	   p = new Personne ("Alice", ddn);
	   // Programme
	   String attendu = Integer.toString(anneeNaiss);
	   String sortie = p.getAnneeNaissance(); 
	   assertEquals(attendu, sortie);
   }
   
   @Test(expected = NullPointerException.class)
   public void testddnException() {
	   // Initialisation
	   Calendar ddn = null;
	   p = new Personne ("Alice", ddn);
	   // Programme
	   String attendu = Integer.toString(anneeNaiss);
	   String sortie = p.getAnneeNaissance();
	   // Pas d'assertion
   }
 
   
   @Test()
   public void testmois() {
	   Calendar ddn = new GregorianCalendar(1989,1,1);
	   p = new Personne ("Alice", ddn);
	   assertEquals(Integer.toString(moisNaiss),p.getMoisNaissance());
   }
}