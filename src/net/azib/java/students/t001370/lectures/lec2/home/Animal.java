package net.azib.java.students.t001370.lectures.lec2.home;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Animal
 *
 * @author maksim
 */
public abstract class Animal implements Comparable<Animal>, Cloneable {
	// TODO: it is a bad idea to use String-representation for Dates
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private String animalName;
	private Date   animalBirthDate;
	private int age;
	
	/**
	 * Class Animal constructor
	 * 
	 * @param name - animal name
	 */
	Animal(String name){
		animalName = name;
	}
	
	/**
	 * Class Animal constructor
	 * 
	 * @param name - animal name
	 * @param birthDay - animal birth date (format: "dd.MM.yyyy")
	 */
	Animal(String name, String birthDay){
		animalName = name;

		try {
			Date date = dateFormat.parse(birthDay);
			animalBirthDate = date;
		}
		catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return Returns animal name
	 */
	String getName(){
		return animalName;
	}
	
	/**
	 * 
	 * @return Return animal age in years
	 */
	int getAge(){
        Date now = new Date();
		int animalAge = 0;
        
		age = animalAge = now.getYear() - animalBirthDate.getYear();
		
		return animalAge;
	}
	
	/**
	 * Gives the possibility to set animal birth date if 
	 * it wasn't set by constructor
	 * @param birthDay animal birth date (format: "dd.MM.yyyy")
	 */
	void setAge(String birthDay){
		try {
			Date date = dateFormat.parse(birthDay);
			animalBirthDate = date;
		}
		catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * For 'making' animal sound 
	 */
	abstract void makeSound();
	
	
	
	public int compareTo(Animal that) {
		return new Integer(age).compareTo(that.age);
	}

	/**
	 * Returns information about the animal
	 */
	public final String toString(){
		String returnString = "";
		
		returnString = getClass().getSimpleName() + " name is: " + animalName + "\n";
		if (animalBirthDate != null) {
			returnString += animalName + "'s birth day is on " + 
								dateFormat.format(animalBirthDate) + "\n" +  
			   				animalName + " is " + getAge() + " years old";
		}
		return returnString;
	}

	/*alt+shift+s */
	@Override
	public boolean equals(Object that) {
		if (that instanceof Animal)
			return this.animalName.equals(((Animal)that).animalName);
		else
			return false;
	}

	@Override
	public int hashCode() {
		return animalName.hashCode();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	//getClass.getSimpleName(); väljastab classi nime
}
