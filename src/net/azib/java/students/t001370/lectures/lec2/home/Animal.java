package net.azib.java.students.t001370.lectures.lec2.home;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Animal
 * Hometask: Create an abstract class Animal with 
 * common fields and methods for all animals, like 
 * name and age. Make some abstract methods as well, 
 * like makeSound(). Implement a few concrete animal 
 * types by extending the Animal, like Dog, Cat, 
 * Cock, Cow, etc. Make sure each of them has some 
 * distinct properties as well as common ones inherited 
 * from Animal. Implement toString(). 
 * Create an Animal[] array, fill it with different 
 * animals, and output them to the screen using 
 * 'for each' loop.
 *
 * @author maksim
 */
public abstract class Animal {
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	private String animalName;
	private Date   animalBirthDate;
	
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
        
		animalAge = now.getYear() - animalBirthDate.getYear();
		
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
	
	/**
	 * Returns information about the animal
	 */
	public final String toString(){
		String returnString = "";
		
		returnString = "Animal name is: " + animalName + "\n";
		if (animalBirthDate != null) {
			returnString += animalName + "'s birth day is on: " + 
								dateFormat.format(animalBirthDate) + "\n" +  
			   				animalName + " is " + getAge() + " years old";
		}
		return returnString;
	}

}
