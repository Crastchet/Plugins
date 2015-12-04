package plugins;

public class ToUpperCase implements Plugin {

	@Override
	public String transform(String str) {
		if(str != null)
			return str.toUpperCase();
		return null;
	}

	@Override
	public String getLabel() {
		return "To Upper Case";
	}

	
}
