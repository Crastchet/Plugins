package menu;

import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugins.Plugin;
import plugins.ToUpperCase;
import view.PluginFrame;


public class ToolsMenu extends JMenu implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Plugin> plugins;

	private PluginFrame pluginFrame;
	
	public ToolsMenu(PluginFrame pf) {
		super("t_Tools");
		plugins = new ArrayList<Plugin>();
		pluginFrame = pf;
	}

	@Override
	public void updatePluginList(ArrayList<Plugin> plugs) { // Bon là on recharge toute la liste, on leur remet une AbstractAction, c'est lourd.. Voir si on peut éviter en chargent tout ça plus tôt dans pluginfinder
		plugins = plugs;
		if(plugins == null || plugins.size() == 0)
			return;
		this.removeAll();
		
		for(Plugin p : plugins) {
			this.add(new JMenuItem(new AbstractAction(p.getLabel()) {

				@Override
				public void actionPerformed(ActionEvent e) {
					String str;
					if(pluginFrame.getTextArea().getSelectedText() == null)
						str = pluginFrame.getTextArea().getText();
					else
						str = pluginFrame.getTextArea().getSelectedText();
					pluginFrame.setTextArea(p.transform(str));
				}
			}));
		}
	}
}
