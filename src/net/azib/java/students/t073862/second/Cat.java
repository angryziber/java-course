package net.azib.java.students.t073862.second;

/**
 * Cat
 *
 * @author Pets
 */
public class Cat extends Pet {
	/**
	 * Is this cat a male?
	 */
	boolean male = false;
	
	/**
	 * @param age
	 * @param name
	 */
	public Cat(int age, String name) {
		super(age, name);
		
	}
	/**
	 * Getter for male
	 */
	public boolean getMale() {
		return male;
	}
	/**
	 * Setter for male
	 * @param b
	 */
	public void setMale(Boolean b) {
		this.male = b;
	}
	
	@Override
	void makesound() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "I am a " + super.getAge() + " year old" + (getMale() ? " male " : " female ") +"cat that goes by the name " + super.getName();
	}

	

}
