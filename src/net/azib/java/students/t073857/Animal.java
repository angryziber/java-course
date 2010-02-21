package net.azib.java.students.t073857;

/**
 * Animal
 *
 * @author Joonas Vali
 */
public abstract class Animal {
	private int weight;
	private int age;	
	private int movingSpeed;
	Gender gender;
	
	public abstract void move();
	public abstract void makeSound();
	public abstract void description();
	public abstract String toString();
	
	public Animal(int weight, int age, int movingSpeed, Gender gender){
		this.weight = weight;
		this.age = age;
		this.movingSpeed = movingSpeed;
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getMovingSpeed() {
		return movingSpeed;
	}
	
	
	
}
