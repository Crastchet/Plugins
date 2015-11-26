package finder;

import java.io.File;

/**
 * PluginFinder is a class which finds all plugins in a directory and add it to 
 * the droppins directory
 * It will be used by an extendable editor, given by our teachers.
 * @author Coilliaux Thibault
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 * @implements FilenameFilter
 *
 */

public class PluginFinder {
	File directory;
	PluginFilter filter;
	
	/**
	 * Constructor for a plugin finder
	 * @param directory the directory where the plugin are
	 */
	public PluginFinder(File directory) {
		this.directory = directory;
		filter = new PluginFilter();
	}
	
	public File[] getClassFiles() {
		return directory.listFiles(filter);
	}
}
