package cms.cm;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JUnitParametrized {
   private Integer n;
   private Boolean expectedResult;
   private TestNombrePremier nbPremier;

   @Before
   public void initialize() {
      nbPremier = new TestNombrePremier();
   }

	
   public JUnitParametrized(Integer _n, Boolean expectedResult) {
      this.n = _n;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, true },
         { 6, false },
         { 19, true },
         { 22, false },
         { 23, true }
      });
   }

   @Test
   public void testparametrized() {
      System.out.println("Parameterized Number is : " + n);
      assertEquals(expectedResult, 
      nbPremier.premier(n));
   }
}