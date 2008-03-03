package net.azib.java.students.t040750.hometasks.lesson2;

/**
 * Animal
 * 
 * @author karpo
 */
public abstract class Animal implements Comparable<Animal>, Cloneable {

	private String name;
	private byte age;
	private String color;

	public Animal(String name, byte age, String color) {
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

	public byte getAge() {
		return age;
	}

	protected void setAge(byte age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
	}

	public abstract void makeSound();

	@Override
	public boolean equals(Object that) {
		if(that instanceof Animal)
			return this.getName().equals(((Animal)that).getName());
		else
			return false;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public int compareTo(Animal that) {
		return new Byte(getAge()).compareTo(that.getAge());
	}
	
	@Override
	public String toString() {
		return "I am a " + getColor() + " " + getClass().getSimpleName() 
		+ " named " + getName()	+ " and I am " + getAge() + " years old";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
