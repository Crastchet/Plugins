package plugins;

public abstract interface Plugin {
	
	public String transform(String str);
	public String getLabel();
}
