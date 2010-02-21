package net.azib.java.students.t073857;

/**
 * Cat
 *
 * @author Joshua
 */
public class Cat extends Pet{
	/**
	 * @param name
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public Cat(String name, int weight, int age, int movingSpeed, Gender gender) {
		super(name, weight, age, movingSpeed, gender);		
	}	
	
	void makeSound() {
		System.out.println("The cat called "+getName()+" says \"meow\", maybe you should give "+gender.thirdObject()+" some food.");
		
	}
	
	void move() {
		System.out.println("You poke the cat. The cat called "+getName()+" moves lazily to a different place, "+gender.thirdSubject()+" doesn't look very happy about it...");
		
	}
	
	void stroke() {		
		System.out.println("You stroke the cat called "+getName()+", "+gender.thirdSubject()+" starts to purr...");
		
	}
}
