package net.azib.java.students.t020281.homework;

/**
 * Cow
 *
 * @author Trial
 */
public class Cow extends Animal {
	
	private int milkPerWeek;
	
	
	/**
	 * @param milkPerWeek the milkPerWeek to set
	 */
	public void setMilkPerWeek(int milkPerWeek) {
		this.milkPerWeek = milkPerWeek;
	}
	
	/**
	 * @return the milkPerWeek
	 */
	public int getMilkPerWeek() {
		return milkPerWeek;
	}
	
	/**
	 * 
	 */
	public Cow(String nameOfAnimal) {
		// TODO Auto-generated constructor stub
		super("Cow "+nameOfAnimal);
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#getProperty()
	 */
	@Override
	String getProperty() {
		// TODO Auto-generated method stub
		return "Milk";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#makeSound()
	 */
	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Muu, muu!");
	}

}
