package net.azib.java.students.t011047;

/**
 * Animal
 *
 * @author t011047
 */
public abstract class Animal {
	private String name;
	private byte age;

	public String getName() {
		return name;
	}
	
	public void growUp() {
		age++;
	}
	
	public byte getAge() {
		return age;
	}
	
	public Animal(String name) {
		this.name  = name;
	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;
	}
	
	public abstract String getType();
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return "I am " + getType() + ", my name is " + name + ", I am " + age + " years old";
	}

	@Override
	public boolean equals(Object other) {
		if(other == null || !(other instanceof Animal))
			return false;
	
		return this.getName().equals(((Animal)other).getName()) && this.getClass() == other.getClass();
	}
}
