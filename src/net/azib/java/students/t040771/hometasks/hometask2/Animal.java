package net.azib.java.students.t040771.hometasks.hometask2;

/**
 * Animal
 *
 * @author raido
 */
public abstract class Animal implements Comparable<Animal>, Cloneable {

	protected String name;
	protected String species;
	protected int age;
	protected int legs;
	
	public Animal(String name, String species, int age, int legs) {
		this.name = name;
		this.species = species;
		this.age = age;
		this.legs = legs;
	}
	
	public String toString() {
		return "I am a " + getClass().getSimpleName() + ", my name is " + name 
				+ " and I'm " + age + " years old, " + species + "s have " + legs + " legs.";
	}
	
	abstract void makeSound();
	
	abstract void action();
	
	@Override
	public boolean equals(Object that) {
		if(that instanceof Animal) return this.name.equals(((Animal)that).name);
		else return false;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	public int compareTo(Animal that) {
		return new Integer(age).compareTo(that.age); 
	}
	
}
