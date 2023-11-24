package cms.cmFichiers;



import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;
import junit.framework.TestCase;


public class JUnitTestFileReaderNoTimeout {

	@Test
	public void testFileReader(){
		try{
			TestFileReader t = new TestFileReader("c:/tmp/source.txt");
			Assert.assertEquals("ABCDEFGHIJK", t.lecture());
		}catch(Exception e){
			TestCase.fail();
		}
	}

}
