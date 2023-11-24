package cms.cmConcurrence;


public class Queue {
  private String  valeur;
  private boolean disponible = false;

  public synchronized String get() throws InterruptedException {
    while (disponible == false) {
      wait();
    }
    disponible = false;
    notifyAll();
    return valeur;
  }

  public synchronized void put(String valeur) throws InterruptedException {
    while (disponible == true) {
      wait();
    }
    this.valeur = valeur;
    disponible = true;
    notifyAll();
  }
  
}