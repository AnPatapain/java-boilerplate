package cms.cm;

public class PrintExemple {

   private String nom;

   public PrintExemple(String nom){
      this.nom = nom;
   }
      
   public String print(){
      String txt = nom;
	  System.out.println(txt);
      return txt;
   }   
   
   public String printSalut(){
	  String txt = "Salut "+nom; 
      System.out.println(txt);
      return txt;
   }   
} 