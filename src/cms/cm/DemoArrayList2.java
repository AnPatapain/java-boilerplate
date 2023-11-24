package cms.cm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoArrayList2 {
  public static void main(final String[] args) {
    String[] tableau = { "A", "B", "C", "D" };
    List<String> liste = new ArrayList<String>();

    System.out.println("Contenu du tableau");
    for (String str : tableau) {
      System.out.print(" " + str);
    }

    liste = Arrays.asList(tableau);
    System.out.println("\nContenu de la liste");
    for (String str : liste) {
      System.out.print(" " + str);
    }
    System.out.println("\n");

    tableau[0] = "AA";

    System.out.println("\nContenu de la liste");
    for (String str : liste) {
      System.out.print(" " + str);
    }
    liste.add("E");

    System.out.println("\nContenu du tableau");
    for (String str : tableau) {
      System.out.print(" " + str);
    }
  }
}