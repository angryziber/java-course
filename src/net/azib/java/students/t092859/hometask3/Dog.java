package net.azib.java.students.t092859.hometask3;

/**
 * Dog
 *
 * @author Konstantin
 */
public class Dog extends Pet {

	private final String breed;
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param age
	 * @param isMale
	 * @param name
	 * @param breed
	 */
	public Dog(int age, boolean isMale, String name, String breed) {
		super(age, isMale, true, name);
		this.breed = breed;
	}

	
	@Override
	String doSmthUseful() {
		// TODO Auto-generated method stub
		return "I guard.";
	}

	@Override
	String makeSound() {
		// TODO Auto-generated method stub
		return "Gav!";
	}

}
