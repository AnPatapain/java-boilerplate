package cms.cmFichiers;


import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;


public class JUnitTestPrintWriter {

	@Test(timeout = 500)
	public void testCreationFichier(){
		try{
			TestPrintWriter t = new TestPrintWriter("c:/tmp/newfichier.txt"); // Ce path existe
			t.traitement();
		}catch (Exception e){
			Assert.fail();
		}
	}
	
	@Test(timeout = 500)
	public void testErreurPath(){
		try{
			TestPrintWriter t = new TestPrintWriter("c:/tmp2/newfichier.txt"); // Ce path n'existe pas
			t.traitement();
			Assert.fail();
		}catch (Exception e){
			// Réussite
		}
	}

}
