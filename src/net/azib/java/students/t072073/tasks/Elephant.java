package net.azib.java.students.t072073.tasks;

/**
 * Elephant
 *
 * @author janika
 */
public class Elephant extends Animal {
	/**
	 * the length of trunk is in centimeters
	 */
	private int lengthOfTrunk;
	
	public Elephant(String name, int age, int trunkLength) {
		super(name, age);
		this.lengthOfTrunk = trunkLength;
	}

	@Override
	void makeSound() {
		print("The sound " + lengthOfTrunk + " trumpets");
	}
	
	public int getWeight(){
		int weightInKg;
		if(getAge() < 1){
			weightInKg = 10;
		}
		else if(getAge() < 5){
			weightInKg = 40;
		}
		else if(getAge() < 10){
			weightInKg = 70;
		}
		else{
			weightInKg = 100;
		}
		return weightInKg;
	}

	@Override
	public String toString() {
		//return super.toString();
		String s = getName() + " is " + getAge() + " years old and weighs " + getWeight() + " kg";
		return s;
	}
	
	
}
