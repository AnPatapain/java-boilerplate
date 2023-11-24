package tds.td4_serialize.test;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import tds.td4_serialize.SerializeDeserializeManager;
import tds.td4_serialize.domain.Genre;
import tds.td4_serialize.domain.Personne;

public class TestSerializationNumeroSociale {
	
	@Test
	public void numeroSocialeMustMatchedAfterDeserialization() {
		Personne GrandPere = new Personne("1234567890", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "NGUYEN Ke", "Anh", Genre.Homme, null, null, null);
		
		Personne GrandMere = new Personne("1234567891", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "VO", "Thi Thanh Hai", Genre.Femme, null, null, null);
		
		Personne PetitEnfant1 = new Personne("1234567893", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Alice", "Alice", Genre.Femme, null, null, null);
        Personne PetitEnfant2 = new Personne("1234567894", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Bob", "Bob", Genre.Homme, null, null, null);
		
        Personne[] PetitEnfants = new Personne[] {PetitEnfant1, PetitEnfant2};
        
		Personne Pere = new Personne("1234567892", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "NGUYEN Ke", "An", Genre.Homme, GrandPere, GrandMere, PetitEnfants);
		
		SerializeDeserializeManager.serialize(Pere, "pere.ser");
		Personne Pere_ = (Personne) SerializeDeserializeManager.deserialize("pere.ser");
		
		Assert.assertEquals(Pere.getParent1().getNSS(), Pere_.getNumSociale_parent1());
		Assert.assertEquals(Pere.getParent2().getNSS(), Pere_.getNumSociale_parent2());
		Assert.assertArrayEquals(Arrays.asList(Pere.getEnfants()).stream().map(e -> e.getNSS()).toArray(String[]::new), Pere_.getNumSociale_enfant());
		
		deleteFileAfterTest("pere.ser");
	}
	
	private void deleteFileAfterTest(String pathName){
    	File file = new File(pathName);
    	try {
    		Files.deleteIfExists(file.toPath());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
