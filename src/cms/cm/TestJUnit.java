package cms.cm;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
	
   String message = "Hello World";	
   String messageTest = "Hello Wrold";
   PrintExemple printer = new PrintExemple(message);

   @Test
   public void testPrintMessage() {	  
      assertEquals(messageTest,printer.print());
   }
}