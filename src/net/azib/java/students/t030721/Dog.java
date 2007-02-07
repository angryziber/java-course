package net.azib.java.students.t030721;

/**
 * Dog
 *
 * @author t030721
 */
public class Dog {
	private String name;
	private byte age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Dog(String name, Byte age){
		this.name = name;
		this.age = age;
	}
	public void growUp(){
		age++;
	}
}
