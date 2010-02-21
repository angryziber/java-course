package net.azib.java.students.t073857;

/**
 * Chicken
 *
 * @author Joshua
 */
public class Chicken extends Pet{
	String birdGender; // rooster or chicken
	/**
	 * @param name
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public Chicken(String name, int weight, int age, int movingSpeed, Gender gender) {
		super(name, weight, age, movingSpeed, gender);		
		if(gender.equals(Gender.MALE)) birdGender = "rooster";
		else birdGender = "chicken";
	}	
	
	public void makeSound() {
		System.out.println("The "+birdGender+" called "+getName()+" says something funny, but you are too busy to listen to "+gender.thirdPosessive()+" "+birdGender+"talk right now.");
		
	}
	
	public void move() {
		System.out.println("The "+birdGender+" called "+getName()+" moves to a different place and looks pretty much the same as before...");
		
	}
	
	public void layEgg(){		
		if(gender == Gender.MALE)
			System.out.println("The "+birdGender+" called "+getName()+" lays an egg and gets into the Guiness World Records!");
		else
			System.out.println("The "+birdGender+" called "+getName()+" lays an egg! It shall be called an Omlette!");
	}
	
	void stroke() {		
		System.out.println("You stroke the "+birdGender+" called "+getName()+", "+gender.thirdSubject()+" is still shocked from watching the cooking channel.");
		
	}

	@Override
	public String toString() {
		return getName()+" the "+birdGender;
	}

	
}
