package tds.td4_serialize.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tds.td4_serialize.domain.*;
import tds.td4_serialize.SerializeDeserializeManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestSerializationPersonne {
    private static Personne alice, bob, charlie, dana, enzo, fatima;
    @BeforeClass
    public static void init() {
        alice = new Personne("1234567890", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Alice", "Alice", Genre.Femme, null, null, null);
        bob = new Personne("1234567891", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Bob", "Bob", Genre.Homme, null, null, null);
        charlie = new Personne("1234567892", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Charlie", "Charlie", Genre.Homme, null, null, null);
        dana = new Personne("1234567893", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Dana", "Dana", Genre.Femme, null, null, null);
        enzo = new Personne("1234567894", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Enzo", "Enzo", Genre.Homme, null, null, null);
        fatima = new Personne("1234567895", new GregorianCalendar(1980, Calendar.JANUARY, 1),
                "Fatima", "Fatima", Genre.Femme, null, null, null);
    }

    @Test
    public void test() {
        // Serialize
        SerializeDeserializeManager.serialize(alice, "alice.ser");
        SerializeDeserializeManager.serialize(bob, "bob.ser");
        SerializeDeserializeManager.serialize(charlie, "charlie.ser");
        SerializeDeserializeManager.serialize(dana, "dana.ser");
        SerializeDeserializeManager.serialize(enzo, "enzo.ser");
        SerializeDeserializeManager.serialize(fatima, "fatima.ser");

        // Deserialize
        alice = bob = charlie = dana = enzo = fatima = null;

        alice = (Personne) SerializeDeserializeManager.deserialize("alice.ser");
        bob = (Personne) SerializeDeserializeManager.deserialize("bob.ser");
        charlie = (Personne) SerializeDeserializeManager.deserialize("charlie.ser");
        dana = (Personne) SerializeDeserializeManager.deserialize("dana.ser");
        enzo = (Personne) SerializeDeserializeManager.deserialize("enzo.ser");
        fatima = (Personne) SerializeDeserializeManager.deserialize("fatima.ser");

        Assert.assertEquals(alice.getNomPrenom(), "Alice Alice");
        Assert.assertEquals(bob.getNomPrenom(), "Bob Bob");
        Assert.assertEquals(charlie.getNomPrenom(), "Charlie Charlie");
        Assert.assertEquals(dana.getNomPrenom(), "Dana Dana");
        Assert.assertEquals(enzo.getNomPrenom(), "Enzo Enzo");
        Assert.assertEquals(fatima.getNomPrenom(), "Fatima Fatima");
        Assert.assertEquals(alice.getNSS(), "1234567890");
        
        deleteSerializedFile("alice.ser");
        deleteSerializedFile("bob.ser");
        deleteSerializedFile("charlie.ser");
        deleteSerializedFile("dana.ser");
        deleteSerializedFile("enzo.ser");
        deleteSerializedFile("fatima.ser");
    }
    private void deleteSerializedFile(String fileName) {
    	File file = new File(fileName);
    	try {
			Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
