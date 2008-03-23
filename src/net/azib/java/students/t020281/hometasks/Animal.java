package net.azib.java.students.t020281.hometasks;

/**
 * animal
 *
 * @author Trial
 */
public abstract class Animal {

	private String name;
	private String color;
	private int age; 
		
	abstract void makeSound();
	abstract String getProperty();
	
/**
 * 
 */
public Animal(String argument) {
	// TODO Auto-generated constructor stub
	super();
	name = argument;
}



public void setColor(String col) {
	color=col;
}

/**
 * @return the color
 */
public String getColor() {
	return color;
}

/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}

/**
 * @return the age
 */
public int getAge() {
	return age;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	// TODO Auto-generated method stub
	return name;
}



}
