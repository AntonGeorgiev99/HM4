package fmi.homework.zad2;

import fmi.informatics.events.Observable;
import fmi.informatics.events.Observer;

public class Person1 implements Observer {
	
	
	private String name;
	private Observable observable;

	public Person1(String name, Observable observable) {
		this.name = name;
		this.observable = observable;
	}
	
	
	private void sayHello() {
		System.out.println(name + " Здравейте!" + observable.getClass().getSimpleName());
		
	}

	@Override
	public void update() {
		sayHello();
		
	}

	


	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}
	
}