package plugins;

public abstract class Plugin {
	private String name;
	
	public Plugin(String n) {
		this.name = n;
	}
	
	public static String action(String theString) {
		//TODO: use a decorator ? (TP piscine)
		return theString;
		//DoesNothing Since it will me overriden by every plugin
	}
	
	public static String getName() {
		return "empty plugin";
	}
}
