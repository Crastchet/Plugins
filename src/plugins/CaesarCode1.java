package plugins;

public class CaesarCode1 extends CaesarCode {
	
	@Override
	public String transform(String str) {
		if(str != null)
			return this.rollLetters(str, 1);
		return null;
	}
	
	@Override
	public String getLabel() {
		return "Code César 1";
	}
}
