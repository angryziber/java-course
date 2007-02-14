package net.azib.java.students.t030655.Lab2;

/**
 * Animal
 *
 * @author t030655
 */
public abstract class Animal {
	private String name;
	private byte age;

	
	public String getName() {
		return name;
	}
	
	public byte getAge() {
		return age;
	}
	
	public void growUp(){
		age++;
	}
	
	public Animal(String name) {
		this.name = name;
	}
	
	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public abstract String getType();
	
	@Override
	public final String toString() {
		return "I am " + getType() + ", my name is " + name + 
				", I am " + age + " years old";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Animal))
			return false;
	
		return this.getName().equals(((Animal)other).getName()) &&
				this.getClass() == other.getClass();
	}
	
	

}
