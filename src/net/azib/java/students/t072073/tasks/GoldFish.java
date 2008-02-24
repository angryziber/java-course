package net.azib.java.students.t072073.tasks;

/**
 * GoldFish
 *
 * @author t072073
 */
public class GoldFish extends Animal {

	public GoldFish() {
		super.setName("Goldie");
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t072073.tasks.Animal#animalClass()
	 */
	@Override
	String animalClass() {
		return "Fish";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t072073.tasks.Animal#makeSound()
	 */
	@Override
	void makeSound() {
		System.out.println("..oo00OOO00oo..");
	}
	
	void origin(String place){
		System.out.println("The goldfish is from " + place);
	}

}
