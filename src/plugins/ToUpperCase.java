package plugins;

public class ToUpperCase implements Plugin {

	@Override
	public String transform(String str) {
		return str.toUpperCase();
	}

	@Override
	public String getLabel() {
		return "To Upper Case";
	}

	
}
