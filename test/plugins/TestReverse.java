package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.Reverse;

public class TestReverse {

	Reverse R = new Reverse();
	String tmp = "abc";
	
	@Test
	public void TestTransform(){
		assertEquals("cba",R.transform(tmp));
	}

	@Test
	public void testGetLabel(){
		assertEquals("Reverse", R.getLabel());
	}
	
}
