package fmi.homework.zad2;

import java.util.ArrayList;
import java.util.List;

import fmi.informatics.events.Observer;

public class People implements Observable {

	
private List<Observer> people = new ArrayList<>();
	
	public void Person(String string) {
		
	}
	
	
	@Override
	public void addObserver(Observer o) {
		people.add(o);
		
	}


	@Override
	public void removeObserver(Observer o) {
		people.remove(o);
		
	}

	@Override
	public void notifyObserver() {
		people.notifyAll();
		
	}


	

}

	
	


