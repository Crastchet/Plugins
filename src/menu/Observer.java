package menu;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import plugins.Plugin;

public interface Observer {

	public abstract void updatePluginList(ArrayList<Plugin> plugs);

}
