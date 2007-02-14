package net.azib.java.students.t960644;

/**
 * Animal
 *
 * @author t960644
 */
public abstract class Animal {
	private String name;
	private byte age;
	
	public String getName(){
		return name;
	}
	public Animal(String name ) {
		this.name = name;
		this.age = 0;
	}
	public Animal(String name, byte age ) {
		this.name = name;
		this.age = age;
	}
	public byte getAge() {
		return age;
	}
	public void growUp(byte age) {	
		this.age++;
	}
	
	public abstract String getType();
	
	@Override
	public final String toString() {
		return "I am "+getType()+", my name is "+name+" and I'm "+age;
	}
	@Override
	public boolean equals(Object other) {
		if (other == null || !(other instanceof Animal)) 
			return false;
		return this.getName().equals(((Animal)other).getName()) && 
			this.getClass()==other.getClass();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
//		return super.hashCode();
		return getName().hashCode() + getClass().hashCode();
	}
	
}
