package finder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import javax.swing.Timer;

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
public class PluginFinder extends Observable {
	File directory;
	File[] files;
	PluginFilter filter;
	Timer timer;
	
	/**
	 * Constructor for a plugin finder
	 * @param directory the directory where the plugin are
	 */
	public PluginFinder(String pathDirectory) {
		this.directory = new File(pathDirectory);
		this.filter = new PluginFilter();
		this.timer = new Timer(1000, checkDirectoryPlugin);
	}
	
	ActionListener checkDirectoryPlugin = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			File[] tmp=directory.listFiles();
			for(int i=0; i<tmp.length; i++){
				if(!filesContainsFile(tmp[i].getName())){
					if(!filter.accept(directory, tmp[i].getName())){
						System.out.println("The file "+tmp[i].getName()+" is not a plugin. \n Delete a file "+tmp[i].getName());
						tmp[i].delete();
					}
					
				}
			}
		}
	};
	
	public boolean filesContainsFile(String name){
		for(int i=0; i<files.length; i++){
			if(files[i].getName()==name)
				return true;
		}
		return false;
	}
	
	public File[] getClassFiles() {
		return directory.listFiles(filter);
	}
}
