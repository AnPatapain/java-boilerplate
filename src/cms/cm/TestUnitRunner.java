package cms.cm;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestUnitRunner {
   public static void main(String[] args) {
      //Result result = JUnitCore.runClasses(HelloJUnit.class);
	   Result result = JUnitCore.runClasses(JUnitTestSuiteExemple.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
} 