package net.azib.java.students.t092875.hw2;

/**
 * Animal
 *
 * @author Mihhail
 */
public abstract class Animal {
	protected int age;
	protected int weight;
	
	/**
	 * Creates a new animal
	 * @param age
	 * @param weight
	 */
	Animal(int age,int weight){
		this.age = age;
		this.weight = weight;
	}
	/**
	 * @return String of what sound the animal makes
	 */
	abstract public String makeSound();
	
	@Override
	public String toString(){
		return "This is a " + this.getClass().getSimpleName().toLowerCase()+
		". It is "+this.age+" years old and it weights "+this.weight+"kg"+
		". The sound it makes is: "+this.makeSound()+". ";
	}
	
}
