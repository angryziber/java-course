package net.azib.java.students.t072073.tasks;

/**
 * Sheep
 *
 * @author janika
 */
public class Sheep extends Animal{

	public Sheep(String name, int age) {
		super(name, age); 
	}

	@Override
	void makeSound() {
		System.out.println("Mää");		
	}
	
	public int amountOfWoolInKg(){
		int woolAmount = getAge() * 10;
		return woolAmount;
	}

	@Override
	public String toString() {
		return getName() + " is " + getAge() + " years old and gives" + amountOfWoolInKg() + " kg of wool";
	}
}
