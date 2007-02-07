package net.azib.java.students.t030630;

/**
 * Dog
 *
 * @author t030630
 */
public class Dog {
	private String name = "Bobik";
	private byte age = 1;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public Dog(String name, byte age) {
		super();
		this.name = name;
		this.age  = age;
	}

	/**
	 * @param name
	 */
	public Dog(String name) {
		super();
		this.name = name;
	}

	public void growUp(){
		age++;
	};
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}
	
	
}
