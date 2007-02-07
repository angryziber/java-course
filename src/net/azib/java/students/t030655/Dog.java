package net.azib.java.students.t030655;

/**
 * Dog
 *
 * @author t030655
 */
public class Dog {
	private String name;
	private byte age;

	
	public Dog(String name, byte age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	
	public byte getAge() {
		return age;
	}
	
	public void growUp(){
		age++;
	}
	
	public Dog(String name) {
		this.name = name;
	}

}
