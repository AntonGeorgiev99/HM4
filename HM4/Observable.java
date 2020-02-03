package fmi.homework.zad2;

import fmi.informatics.events.Observer;

public interface Observable {

	public void addObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}
