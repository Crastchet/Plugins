package plugins;

public class Reverse implements Plugin {

	@Override
	public String transform(String str) {
		StringBuilder lettersBuff = new StringBuilder(str);
		return lettersBuff.reverse().toString();
	}

	@Override
	public String getLabel() {
		return "Reverse";
	}

}
