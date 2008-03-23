package net.azib.java.students.t020281.hometasks;

/**
 * Doggy
 *
 * @author Trial
 */
public class Doggy extends Animal {

	private String breed;
	
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	/**
	 * @param argument
	 */
	public Doggy(String argument) {
		super("Dog "+argument);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#getProperty()
	 */
	@Override
	String getProperty() {
		// TODO Auto-generated method stub
		return "Security";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020281.homework.animal#makeSound()
	 */
	@Override
	void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Gav, gav!");
	}

}
