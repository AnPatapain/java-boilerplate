package tds.td4_serialize.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Personne implements Serializable {
    private String numeroSecu = "";
    private Calendar dateDeNaissance;
    private String nom;
    private String prenom;
    private Genre genre;

    private Personne parent1;
    private Personne parent2;
    private List<Personne> enfants;
    
    private String numSociale_parent1;
    private String numSociale_parent2;
    private String[] numSociale_enfant;
    
    public Personne(){}

    public Personne(String _numeroSecu, Calendar _dateDeNaissance, String _nom, String _prenom, Genre _genre) {
        this(_numeroSecu, _dateDeNaissance, _nom, _prenom, _genre, null, null, null);
    }
    public Personne(String _numeroSecu, Calendar _dateDeNaissance,
                    String _nom, String _prenom, Genre _genre,
                    Personne _parent1, Personne _parent2) {
        this(_numeroSecu, _dateDeNaissance, _nom, _prenom, _genre, _parent1, _parent2, null);
    }
    public Personne(String _numeroSecu, Calendar _dateDeNaissance,
                    String _nom, String _prenom,
                    Genre _genre, Personne[] _enfants) {
        this(_numeroSecu, _dateDeNaissance, _nom, _prenom, _genre, null, null, _enfants);
    }
    public Personne(String _numeroSecu, Calendar _dateDeNaissance,
                    String _nom, String _prenom, Genre _genre,
                    Personne _parent1, Personne _parent2,
                    Personne[] _enfants) {
        this();
        this.numeroSecu = _numeroSecu;
        this.dateDeNaissance = _dateDeNaissance;
        this.nom = _nom;
        this.prenom = _prenom;
        this.genre = _genre;
        this.parent1 = _parent1;
        this.parent2 = _parent2;

        if(_enfants != null) {
            this.enfants = new Vector<Personne>();
            Collections.addAll(this.enfants, _enfants);
        }
    }

    public String getNomPrenom() {
        return nom + " " +  prenom;
    }

    public int getAge(Calendar dateDuJour) {
        return dateDuJour.get(Calendar.YEAR) - dateDeNaissance.get(Calendar.YEAR);
    }

    public String getNSS() {
        return this.numeroSecu;
    }

    public void addEnfant(Personne _e) {
        this.enfants.add(_e);
    }

    public Personne[] getEnfants() {
        Personne[] enfantsArray = new Personne[this.enfants.size()];
        for(int i = 0; i < this.enfants.size(); i++) {
        	enfantsArray[i] = this.enfants.get(i);
        }
        return enfantsArray;
    }
    
    public Personne getParent1() {
		return parent1;
	}
    
    public Personne getParent2() {
		return parent2;
	}
    
    public String getNumSociale_parent1() {
		return numSociale_parent1;
	}
    
    public String getNumSociale_parent2() {
		return numSociale_parent2;
	}
    
    public String[] getNumSociale_enfant() {
		return numSociale_enfant;
	}
    
    private void writeObject(ObjectOutputStream os) {
    	try {
			os.defaultWriteObject();
			os.writeObject(parent1 != null ? parent1.getNSS() : null);
			os.writeObject(parent2 != null ? parent2.getNSS() : null);
			os.writeObject(enfants != null && enfants.size() != 0 ? 
					enfants.stream().map(e -> e.getNSS()).toArray(String[]::new):null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void readObject(ObjectInputStream is) {
    	try {
			is.defaultReadObject();
			this.numSociale_parent1 = (String)is.readObject();
			this.numSociale_parent2 = (String)is.readObject();
			this.numSociale_enfant = (String[])is.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
