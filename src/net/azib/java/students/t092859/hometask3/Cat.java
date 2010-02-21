package net.azib.java.students.t092859.hometask3;

/**
 * Cat
 *
 * @author Konstantin
 */
public class Cat extends Pet{

	private int livesRemaining = 9;
	
	/**
	 * @return the lifesRemaining
	 */
	public int getLivesRemaining() {
		return livesRemaining;
	}

	public void decreaseLivesRemaining(){
		if(livesRemaining > 0)
			livesRemaining--;
	}

	/**
	 * @param age
	 * @param isMale
	 * @param name
	 */
	public Cat(int age, boolean isMale, String name) {
		super(age, isMale, true, name);
	}
	
	@Override
	String petSpecificText() {
		return "I have " + Integer.toString(livesRemaining) + " lives left. ";
	}
		
	@Override
	String doSmthUseful() {
		return "I catch mice.";
	}

	@Override
	String makeSound() {
		return "Meow!";
	}



	
}
