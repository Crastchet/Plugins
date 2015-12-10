package plugins;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import plugins.ToLowerCase;;

public class TestToLowerCase {

	
	ToLowerCase TLC = new ToLowerCase();
	String tmp = "ABC";
	
	@Test
	public void TestTransform(){
		assertEquals("abc",TLC.transform(tmp));
	}
	
	@Test
	public void testGetLabel(){
		assertEquals("En minuscules", TLC.getLabel());
	}
	
}
