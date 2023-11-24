package examenExemple.myWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GestionDisque {
	private static final String dataFolder = "data";
	
	static {
		File dataDir = new File(dataFolder);
		if(!dataDir.exists()) {
			dataDir.mkdir();
		}
	}
	
	public static void sauvergarderPersonnes(Personnes personnes) {
		for(Personne personne : personnes.getPersonnes()) {
			String fileName = dataFolder + File.separator + "personne-" + personne.getId() + ".dat";
			serialize(personne, fileName);
		}
	}
	
	public static Personne chargerPersonne(String fileName) {
		Personne personne = (PersonneChiffre) deserialize(fileName);
		return personne;
	}
	
	public static Personnes chargerTous() {
		Personnes personnes = new Personnes();
		File data = new File(dataFolder);
		File[] files = data.listFiles((dir, name) -> name.endsWith(".dat"));
		
		if(files != null) {
			for(File file : files) {
				Personne personne = (PersonneChiffre) deserialize(file.getPath());
				personnes.addPersonne(personne);
			}
		}
		return personnes;
	}
	
	public static void serialize(Serializable object, String fileName) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object deserialize(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
