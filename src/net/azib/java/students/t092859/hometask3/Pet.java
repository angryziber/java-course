package net.azib.java.students.t092859.hometask3;

/**
 * Pet
 *
 * @author Konstantin
 */
public abstract class Pet extends Animal {

	private String name;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param age
	 * @param isMale
	 * @param isCarnivore
	 * @param name
	 */
	public Pet(int age, boolean isMale, boolean isCarnivore, String name) {
		super(age, isMale, isCarnivore);
		this.name = name;
	}
	
	@Override
	String animalSpecificText() {
		return "My name is " + name + ". " + petSpecificText() + doSmthUseful() + " " + makeSound();
	}
	String petSpecificText(){
		return "";
	}
	abstract String makeSound();
	abstract String doSmthUseful();
	
	String askFood(){
		return "I'm hungry.";
	}
	
	String meetOwner(){
		return makeSound() + askFood();
	}
	
}
