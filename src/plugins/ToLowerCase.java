package plugins;

public class ToLowerCase implements Plugin {

	@Override
	public String transform(String str) {
		if(str != null)
			return str.toLowerCase();
		return null;
	}

	@Override
	public String getLabel() {
		return "En minuscules";
	}

}
