package plugins;

public class CaesarCode13 extends CaesarCode {

	@Override
	public String transform(String str) {
		if(str != null)
			return this.rollLetters(str, 13);
		return null;
	}

	@Override
	public String getLabel() {
		return "Code César 13";
	}

}
