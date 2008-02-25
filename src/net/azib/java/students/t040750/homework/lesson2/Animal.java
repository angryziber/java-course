package net.azib.java.students.t040750.homework.lesson2;

/**
 * Animal
 *
 * @author karpo
 */
public abstract class Animal {

	private String name;
	private String age;
	private String color;
	
	public Animal(String name, String age, String color) {
		setName(name);
		setAge(age);
		setColor(color);
	}
	
	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	protected void setAge(String age) {
		this.age = age;
	}
	
	public String getColor() {
		return color;
	}
	protected void setColor(String color) {
		this.color = color;
	}
	
	public abstract void makeSound();
	
}
