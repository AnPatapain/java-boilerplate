package cms.cmFichiers;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class JUnitTestBufferedReader{

	@Test(timeout = 500)
	public void testType(){
		try{
			TestBufferedReader t = new TestBufferedReader("c:/tmp/source.txt");
			Assert.assertEquals("ABCDEFGHIJK", t.lecture());
		}catch(Exception e){
			TestCase.fail();
		}
	}

}
