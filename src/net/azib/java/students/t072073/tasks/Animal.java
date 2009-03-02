package net.azib.java.students.t072073.tasks;

/**
 * Animal
 *
 * @author janika
 */
abstract class Animal {
	
	private String name;
	private int age;
	
	public Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	public void print(String text){
		System.out.println(text);
	}
	public int getAge(){ return age; }
	public String getName(){ return name; }
	abstract void makeSound();
}
