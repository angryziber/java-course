package net.azib.java.students.t654321.hometasks;

/**
 * Animal
 *
 * @author karl
 */
public abstract class Animal {
	
	private String name;
	private String color;
	private int age;
	
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}



	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}



	public Animal(String name, String color, int age){
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	abstract void makeSound();
	abstract void jump();
	abstract void fly();
	
}
