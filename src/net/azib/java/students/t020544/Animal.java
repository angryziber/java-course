package net.azib.java.students.t020544;

/**
 * Animal
 * 
 * @author Julija Kondratjeva
 */
public abstract class Animal implements IAnimal {
	private String name;
	private byte age;

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020544.IAnimal#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020544.IAnimal#growUp()
	 */
	public void growUp() {
		age++;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020544.IAnimal#getAge()
	 */
	public byte getAge() {
		return age;
	}

	public Animal(byte age) {
		this.age = age;

	}

	public Animal(String name, byte age) {
		this.name = name;
		this.age = age;

	}

	public void testInstanceMethod() {
		System.out.println("The instance method in Animal.");
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
