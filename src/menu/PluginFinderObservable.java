package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Timer;

import plugins.Plugin;
import finder.PluginFilter;


/**
 * PluginFinder is a class which finds all plugins in a directory and add it to 
 * the droppins directory
 * It will be used by an extendable editor, given by our teachers.
 * @author Coilliaux Thibault
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 * @implements FilenameFilter
 */
public class PluginFinderObservable extends Observable {
	
	private File directory;
	private ArrayList<File> filesPlugins, newFilesPlugins;
	private ArrayList<Plugin> plugins;
	private PluginFilter filter;
	private Timer timer;
	
	/**
	 * Constructor for a plugin finder
	 * @param directory the directory where the plugin are
	 */
	public PluginFinderObservable(String path) {
		super();
		directory = new File(path);
		filesPlugins = new ArrayList<File>();
		plugins = new ArrayList<Plugin>();
		filter = new PluginFilter();
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<File> files = new ArrayList<File>();
				boolean modif;
				for(File tmp : directory.listFiles(filter))
					files.add(tmp);
				if(modif = !files.equals(filesPlugins))
					filesPlugins = files;
				if(modif)
					update();
			}
		});
	}
	
	public void init() {
		this.timer.start();
		this.updateObservers();
	}

	public void update() {
		this.generatePlugins();
		this.updateObservers();
	}
	
	@Override
	public void updateObservers() {
		for(Observer o : this.observers) {
			o.updatePluginList(plugins);
		}
	}
	
	public HashSet<File> getFilesFromDirectory() {
		File[] files = this.directory.listFiles(this.filter);
	    if ((files == null) || (files.length == 0)) {
	      return new HashSet();
	    }
	    return new HashSet(Arrays.asList(files));
	}
	
	public void generatePlugins() {
		plugins.clear();
		for(File f : filesPlugins)
			plugins.add(this.generatePluginFromFile(f));		
	}
	
	public Plugin generatePluginFromFile(File f) {
		Class<? extends Plugin> pluginClass = null;
		try {
			pluginClass = (Class<? extends Plugin>) Class.forName("plugins." + f.getName().replaceFirst("\\.class$", ""));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			return pluginClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
