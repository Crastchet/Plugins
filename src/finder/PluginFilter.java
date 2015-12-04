package finder;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

import plugins.Plugin;


/**
 * PluginFilter is a class which filter the plugins in a directory.
 * It will be used by an extendable editor, given by our teachers.
 * @author Coilliaux Thibault
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 * @implements FilenameFilter
 *
 */

public class PluginFilter implements FilenameFilter {

	/**
	 * A method which filter plugin files
	 */
	public boolean accept(File f, String name) {
		if(!isClassExtension(name))
			return false;
		Class<?> cls = null;
		try {
			cls = Class.forName("plugins." + name.replaceFirst("\\.class$", ""));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(cls == null)
			return false;
		
	    return (this.implementsPlugin(cls) && this.isFromPackagePlugins(cls) && this.hasConstructorNoParam(cls));
	}
	
	public boolean isClassExtension(String name) {
		return name.endsWith(".class");
	}
	
	public boolean implementsPlugin(Class<?> cls) {
		return Plugin.class.isAssignableFrom(cls);
	}
	
	public boolean isFromPackagePlugins(Class<?> cls) {
		return cls.getPackage().getName().equals("plugins");
	}
	
	public boolean hasConstructorNoParam(Class<?> cls) {
		for(Constructor<?> c : cls.getConstructors())
			if(c.getParameters().length == 0)
				return true;
		return false;
	}

}
