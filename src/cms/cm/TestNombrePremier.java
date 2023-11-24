package cms.cm;

public class TestNombrePremier {
	
	   public Boolean premier(Integer nbPremier) {
	      for (int i = 2; i < (nbPremier / 2); i++) {
	         if (nbPremier % i == 0) {
	            return false;
	         }
	      }
	      return true;
	   }
	   
	}