package net.azib.java.students.t030636;

/**
 * Dog
 *
 * @author t030636
 */
public class Dog {
	private String name ;
	private byte age;

	public byte getAge() {
		return age;
	}
	
	public void growUp() {
		age++ ;
	}

	public String getName() {
		return name;
	}
	
	public Dog(String name, byte age) {
		this.name = name;
		this.age = age;
	}
	
}
