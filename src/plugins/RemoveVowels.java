package plugins;

public class RemoveVowels implements Plugin {

	@Override
	public String transform(String str) {
		if(str != null)
			return str.replaceAll("[aeiouy]", "");
		return null;
	}

	@Override
	public String getLabel() {
		return "Supprime voyelles";
	}

}
