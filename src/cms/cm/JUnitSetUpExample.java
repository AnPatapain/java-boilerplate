package cms.cm;

import junit.framework.*;

public class JUnitSetUpExample extends TestCase {
   public int val1, val2;
   
   // assigning the values
   protected void setUp(){
      val1 = 0;
      val2 = 42;
   }
   
   protected void tearDown() {
	   val1 = 0;
	   val2 = 0;
   }

   // test method to add two values
   public void testAdd(){
      double result = val1 + val2;
      assertTrue(result == 42);
   }
}