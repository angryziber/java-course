package net.azib.java.students.t030655.Lab2ja4;

/**
 * Animal
 *
 * @author t030655
 */
public abstract class Animal implements IAnimal {
	private String name;
	private byte age;

	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t030655.Lab2.IAnimal#getName()
	 */
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t030655.Lab2.IAnimal#getAge()
	 */
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

	/* (non-Javadoc)
	 * @see net.azib.java.students.t030655.Lab2.IAnimal#getType()
	 */
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
	
		return this.getName().equals(((IAnimal)other).getName()) &&
				this.getClass() == other.getClass();
	}
	
	

}
