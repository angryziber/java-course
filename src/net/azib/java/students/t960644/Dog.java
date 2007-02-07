package net.azib.java.students.t960644;

/**
 * Dog
 *
 * @author t960644
 */
public class Dog {
	private String name;
	private byte age;
	public String getName(){
		return name;
	}
	public Dog(String name ) {
		this.name = name;
	}
	public Dog(String name, byte age ) {
		this.name = name;
		this.age = age;
	}
	public byte getAge() {
		return age;
	}
	public void growUp(byte age) {	
		this.age++;
	}
}
