package finder;
import java.io.File;
import java.io.FilenameFilter;


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
		Class<?> myClass = null;
		try {
			myClass = Class.forName("plugins." + name.replaceFirst("\\.class$", ""));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(myClass == null)
			return false;
	    return true;
	}
	
	public boolean isClassExtension(String name) {
		return name.endsWith(".class");
	}

}
