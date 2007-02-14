package net.azib.java.students.t030675;


public abstract class Animal{
	
	private String name;
	private byte age;
	
	/**
	 * 
	 */
	public Animal(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 */
	public Animal(String name, byte age) {
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
	
	public void growUp(){
		this.age++;
	}
	
	public abstract String getType();


	public String toString() {
		return "I am " + getType() + ", I am " + age + "years old";
	}


	public boolean equals(Object other) {
		if(other == null || !(other instanceof Animal)){
			return false;
		}
		return this.getName().equals(((Animal)other).getName())&& this.getClass() == other.getClass();

	}

	public int hashCode() {

		return super.hashCode();
	}
	
	
	
	
}