package net.azib.java.students.t092875.hw2;

/**
 * Pet
 *
 * @author Mihhail
 */
public abstract class Pet extends Animal {
	protected String name;
	/**
	 * Creates a new pet.
	 * @param name - name of the pet
	 * @param age
	 * @param weight
	 */
	Pet(String name, int age, int weight){
		super(age,weight);
		this.name = name;
	}
	/**
	 * @return String with the name of the pet
	 */
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return super.toString()+"Its name is "+this.name+". ";
	}
}
