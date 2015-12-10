package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.CaesarCode;
import plugins.CaesarCode1;

public class TestCaesarCode {
	
	CaesarCode cc = new CaesarCode1();
	String tmp = "aaa";
	
	@Test 
	public void rollLettersTest(){
		assertEquals("ddd",cc.rollLetters(tmp, 3));
		
	}
}
