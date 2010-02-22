package net.azib.java.students.t073862.second;

/**
 * Dog
 *
 * @author Pets
 */
public class Dog extends Pet {
	/**
	 * @param age
	 */
	public Dog(int age, String name) {
		super(age, name);

	}

	@Override
	void makesound() {
		// TODO Auto-generated method stub
		
	}	
	public String toString() {
		return "I am a " + super.getAge() + " year old dog that goes by the name " + super.getName();
	}


}
