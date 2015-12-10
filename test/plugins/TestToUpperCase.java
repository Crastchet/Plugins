package plugins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import plugins.ToUpperCase;;

public class TestToUpperCase {

	
	ToUpperCase TUC = new ToUpperCase();
	String tmp = "abc";
	
	@Test
	public void TestTransform(){
		assertEquals("ABC",TUC.transform(tmp));
	}
	
	@Test
	public void testGetLabel(){
		assertEquals("En majuscules", TUC.getLabel());
	}
	
}
