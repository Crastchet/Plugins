package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

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
	private ArrayList<File> filesPlugins;
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
				boolean modif = false;
				for(File tmp : directory.listFiles(filter))
					if(!(filesPlugins.contains(tmp))) {
						filesPlugins.add(tmp);
						modif = true;
					}
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
