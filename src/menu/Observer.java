package menu;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import plugins.Plugin;

/**
 * Observer is a class which is used to use the Observable design pattern
 * @author Coilliaux Thibault
 * @author Deleplanque Dylan
 * @author Landschoot Ludovic
 * @author Saab Mathieu
 *
 */

public interface Observer {

	/**
	 * A method which updates the list of plugins of the observer
	 * @param plugs the plugins lists
	 */
	public abstract void updatePluginList(ArrayList<Plugin> plugs);

}
