package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.CaesarCode;
import plugins.CaesarCode13;

public class TestCaesarCode13 {

	CaesarCode cc = new CaesarCode13();
	String tmp = "aaa";

	@Test
	public void transformTest() {
		assertEquals("nnn",cc.transform(tmp) );
	}
	
	
	@Test
	public void getLabelTest(){
		assertEquals("Code César 13", cc.getLabel());
	}
}