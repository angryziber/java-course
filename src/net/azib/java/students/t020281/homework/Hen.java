package net.azib.java.students.t020281.homework;

/**
 * Hen
 *
 * @author Trial
 */
public class Hen extends Animal {
	
	private int eggPerDay;
	
	/**
	 * @param eggPerDay the eggPerDay to set
	 */
	public void setEggPerDay(int eggPerDay) {
		this.eggPerDay = eggPerDay;
	}
	
	/**
	 * @return the eggPerDay
	 */
	public int getEggPerDay() {
		return eggPerDay;
	}

	/**
	 * @param argument
	 */
	public Hen(String argument) {
		super("Hen "+argument);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#getProperty()
	 */
	@Override
	String getProperty() {
		// TODO Auto-generated method stub
		return "Eggs";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#makeSound()
	 */
	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Ko, ko, ko!");
	}

}
