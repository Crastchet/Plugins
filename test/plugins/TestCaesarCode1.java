package plugins;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.CaesarCode;
import plugins.CaesarCode1;

public class TestCaesarCode1 {

	CaesarCode cc = new CaesarCode1();
	String tmp = "aaa";

	@Test
	public void transformTest() {
		assertEquals("bbb",cc.transform(tmp) );
	}
	
	
	@Test
	public void getLabelTest(){
		assertEquals("Code César 1", cc.getLabel());
	}
}
