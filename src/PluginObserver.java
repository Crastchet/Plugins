import java.util.Observable;
import java.util.Observer;


public abstract class PluginObserver {

	public abstract void newClassAppeared(Class<?> classFile);

	public abstract void classHasDisappeared(Class<?> classFile);

}
