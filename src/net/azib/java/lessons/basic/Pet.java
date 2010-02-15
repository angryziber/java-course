package net.azib.java.lessons.basic;

/**
 * Pet
 *
 * @author anton
 */
public abstract class Pet implements Cloneable {
	private String name;
	private int age;
	
	/**
	 * @param name
	 * @param age
	 */
	public Pet(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	
	public abstract String getSound();
	
	@Override
	public Pet clone() throws CloneNotSupportedException {
		return (Pet)super.clone();
	}	
}
