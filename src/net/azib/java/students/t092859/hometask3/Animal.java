package net.azib.java.students.t092859.hometask3;

/**
 * Animal
 *
 * @author Konstantin
 */
public abstract class Animal {

	protected int age;
	protected final String gender;
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	protected final boolean isCarnivore;
	
	/**
	 * @param age
	 * @param isMale
	 * @param isCarnivore
	 */
	public Animal(int age, boolean isMale, boolean isCarnivore) {
		super();
		this.gender = isMale ? "male" : "female";
		this.age = age;
		this.isCarnivore = isCarnivore;
	}

	public String Eat (){
		return isCarnivore ? "I eat meat." : "I eat plants.";
	}
	
	String animalSpecificText(){
		return "";
	}

	@Override
	public String toString() {
		return "I am " + Integer.toString(age) + " year old " + gender + " " + this.getClass().getSimpleName().toLowerCase() + 
		". " + Eat() + " " + animalSpecificText();
	}

	
}
