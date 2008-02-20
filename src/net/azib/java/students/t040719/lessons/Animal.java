package net.azib.java.students.t040719.lessons;

/**
 * Animal
 *
 * @author Romi
 */
public abstract class Animal {
	protected String name;
	protected String breed;
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
		str += "\nBreed: " + breed;
		str += "\nName: " + name;
		str += "\nAge: " + age;
		return  str;
	}

}
