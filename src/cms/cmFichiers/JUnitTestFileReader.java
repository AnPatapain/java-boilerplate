package cms.cmFichiers;


import org.junit.Test;
import junit.framework.Assert;
import junit.framework.TestCase;


public class JUnitTestFileReader{
	
@Test(timeout = 500)
public void testFileReader(){
	try{
		TestFileReader t = new TestFileReader("c:/tmp/source.txt");
		Assert.assertEquals("ABCDEFGHIJK", t.lecture());
	}catch(Exception e){
		TestCase.fail();
	}
}

@Test(timeout = 500)
public void testFileReaderAvecTableau(){
	try{
		TestFileReader t = new TestFileReader("c:/tmp/source.txt");
		Assert.assertEquals("ABCDEFGHIJK", t.lectureAvecTableau());
	}catch(Exception e){
		TestCase.fail();
	}
}

}
