package net.azib.java.students.t050724.animals;

/**
 * Bear
 *
 * @author xom
 */
public class Bear extends Animal {

	void hibernate() {	
		System.out.println("Sooo slpeepy, see you in the spring...");		
	}
	
	/**
	 * @param age
	 * @param weight
	 */
	public Bear(int age, int weight) {
		super(age, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	void makeSound() {
		System.out.println("growl, growl, growl");

	}

}
