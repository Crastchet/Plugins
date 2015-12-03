package plugins;

public class ToUpperCase extends Plugin {

	
	
	public ToUpperCase(String name) {
		super("To Upper Case");
	}

	public static String action(String theString) {
		return theString.toUpperCase();
	}

	public static String getName() {
		return "To Upper Case";
	}
	
}
