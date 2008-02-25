package net.azib.java.students.t030611.homework;

/**
 * Dog
 *
 * @author Jekaterina
 */
public class Dog extends Animal {
	private String color;
	
	/**@Override */
	String getVoice() {
		return "Gav!!!";
	}
	Dog(String name, String color, int age){
		super(name,age);
		this.color = color;
	}
	String getColor() {
		final String newColor = color;
		return newColor;
	}
	/** @Override */
	public String toString() {
		return "My dog: color: " + getColor() + ", name: " + getName() + ", age" + getAge()+", says " + getVoice();
	}
}
