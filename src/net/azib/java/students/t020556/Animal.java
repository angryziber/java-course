package net.azib.java.students.t020556;

/**
 * Animal class
 *
 * @author t020556
 */
public abstract class Animal {
	protected String name = "stray";
	protected byte age = 1;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
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
	public Animal(String name, byte age){
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "I am possibly a grizly bear named Teddy... :)";
	}
	
	public abstract String getType();
	
}
