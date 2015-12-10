package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.RemoveVowels;

public class TestRemoveVowels {

	RemoveVowels RV = new RemoveVowels();
	String tmp = "abc";
	@Test
	public void testTransform(){
		assertEquals("bc",RV.transform(tmp));
	}
	
	
	@Test
	public void testGetLabel(){
		assertEquals("Supprime voyelles", RV.getLabel());
	}
}
