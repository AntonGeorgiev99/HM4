package fmi.informatics.extending;

import java.util.Calendar;

import java.util.concurrent.ThreadLocalRandom;

// Дефиниране на клас Student, който разширява абстрактния клас Person.
// Като наследник притежава всички характеристики и методи на класа родител
public class Student extends Person {

	private String university;
	private String speciality;
	private int facNumber;
	private boolean gender;
	private int readBooks;
	private String favObj;

	public Student() {

	}
	
	public Student(String speciality, String university) {
		this.speciality = speciality;
		this.university = university;
	}

	public Student(String name, int egn, String university, String speciality, int facNumber) {
		super(name, egn);
		this.university = university;
		this.speciality = speciality;
		this.facNumber = facNumber;
	}
	
	public Student(String name, int egn, String university, String speciality, int facNumber,
			int age, int height, int weight, boolean gender, int readBooks, String favObj) {
		super(name, egn, age, height, weight);
		this.university = university;
		this.speciality = speciality;
		this.facNumber = facNumber;
		this.gender = gender;
		this.readBooks = readBooks;
		this.favObj = favObj;
	}

	/*
	 * Пренаписване на метод от клас родител. В runtime всички обекти от тип Student ще
	 * извикват само пренаписаният метод, дори и да са дефинирани като обекти от базовият тип
	 */
	@Override
	public void run() {
		System.out.println("The student is running");
	}
	
	@Override
	public String toString() {
		return String.format("The student %s is learning in %s speciality", 
							 this.getName(), this.getSpeciality());
	}

	public void study() {
		System.out.println("The student is studying");
	}

	public void takeExam() {
		System.out.println("The student passed the exam");
	}

	public void goBar(String drink) {
		System.out.println("The student " + getName() +  " drinking " + drink);
	}
	
	// Имплементация на абстрактен метод от супер клас
	@Override
	protected String getTypicalDrink() {
		return "Vodka";
	}
	
	// Имплементация на методите от двата интерфейса (без getShower(), който е
	// имплементиран в абстрактният клас. Ако е необходимо getShower() може да се пренапишe)
	@SuppressWarnings("static-access")
	@Override
	public void getUpEarly(Calendar hour) {
		System.out.println("The student usually gets up at " + hour.HOUR);
	}

	@Override
	public void run(int minutes) {
		// TODO Auto-generated method stub
	}

	@Override
	public void think() {
		// TODO Auto-generated method stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
	}
	
	// Getters and setters
	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getFacNumber() {
		return facNumber;
	}

	public void setFacNumber(int facNumber) {
		this.facNumber = facNumber;
	}
	
	public boolean getGender() {
		return gender;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	public int getReadBooks() {
		return readBooks;
	}
	
	public void setReadBooks(int readBooks) {
		this.readBooks = readBooks;
	}
	
	public String getFavObj() {
		return favObj;
	}
	
	public void setFavObj(String favObj) {
		this.favObj = favObj;
	}
	
	
	
	// Пример за статичен вложен клас
	// Добавяме в класа Student помощен клас за произволно създаване на студенти - StudentGenerator
	public static class StudentGenerator {
		private static String[] names = {"Ivan", "Mariya", "Stoyan", "Petyr", "Petya", "Lilly"};
		private static String[] specialities = {"Informatics", "STD", "BIT", "Mathematics"};
		private static String[] universities = {"PU", "NBU", "SU", "UHT"};
		private static String[] Objects = {"Math", "Music", "Programming"};
		public static Student make() {
			int arrayIndex = ThreadLocalRandom.current().nextInt(0, names.length);
			String name = names[arrayIndex];
			
			arrayIndex = ThreadLocalRandom.current().nextInt(0, specialities.length);
			String speciality = specialities[arrayIndex];
			
			arrayIndex = ThreadLocalRandom.current().nextInt(0, universities.length);
			String university = universities[arrayIndex];
			
			arrayIndex = ThreadLocalRandom.current().nextInt(0, Objects.length);
			String favObj = Objects[arrayIndex];
			
			int facNumber = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			int egn = ThreadLocalRandom.current().nextInt(111111, 999999);
			
			// добавяме генериране на години, височина и тегло
			int age = ThreadLocalRandom.current().nextInt(18, 30);
			
			int height =  ThreadLocalRandom.current().nextInt(150, 220);
			
			int weight = ThreadLocalRandom.current().nextInt(50, 220);
			
			boolean gender = ThreadLocalRandom.current().nextBoolean();
			
			int readBooks = ThreadLocalRandom.current().nextInt(1, 100);
			
			return new Student(name, egn, university, speciality, facNumber, age, height, weight, gender, readBooks, favObj);
		}
	}
}