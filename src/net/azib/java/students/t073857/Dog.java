package net.azib.java.students.t073857;

/**
 * Dog
 *
 * @author Joshua
 */
public class Dog extends Pet{
	
	/**
	 * @param name
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public Dog(String name, int weight, int age, int movingSpeed, Gender gender) {
		super(name, weight, age, movingSpeed, gender);		
	}	
	
	public void makeSound() {
		System.out.println("The dog called "+getName()+" barks at you, you should not enter "+gender.thirdPosessive()+" territory.");
		
	}
	
	public void move() {
		System.out.println("You poke the dog. The dog called "+getName()+" moves lazily to a different place, "+gender.thirdSubject()+" doesn't look very happy about it...");
		
	}
	
	void stroke() {		
		System.out.println("You stroke the dog called "+getName()+", "+gender.thirdSubject()+" looks very happy...");
		
	}

	@Override
	public String toString() {
		return getName()+" the dog";
	}

}
