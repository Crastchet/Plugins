package menu;
import java.util.ArrayList;


public abstract class Observable {

	protected ArrayList<Observer> observers;
	
	public Observable() {
		observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer obs) {
		this.observers.add(obs);
	}
	
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
	}
	
	public abstract void updateObservers();

}
