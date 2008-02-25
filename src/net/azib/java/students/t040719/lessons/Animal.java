package net.azib.java.students.t040719.lessons;

/**
 * Animal
 *
 * @author Romi
 */
public abstract class Animal implements Cloneable {
	protected String name;
	protected String breed;
	// TODO: remove this as getClass() method will return the actuall type
	protected String species;
	protected int age;
	public abstract void makeSound();
	
	/**
	 * 
	 */
	public Animal(String name, String breed, int age, String animalSpecies) {
		this.breed = breed;
		this.name = name;
		this.age = age;
		this.species = animalSpecies;
	}
	
	public Animal() {
		super();
	}
	
	public String getName(){
		return name;
	}
	
	public String getSpecies(){
		return species;
	}

	public String getBreed(){
		return breed;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "Animal: " + species;
		str += "\nBreed: " + getClass().getSimpleName();
		str += "\nName: " + name;
		str += "\nAge: " + age;
		return  str;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) {
		if (that instanceof Animal) 
			return this.name.equals(((Animal)that).name);			
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

}
