package net.azib.java.students.t073857;

/**
 * Wolf
 *
 * @author Joonas Vali
 */
public class Wolf extends WildAnimal{
		
	/**
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public Wolf(int weight, int age, int movingSpeed, Gender gender) {
		super(weight, age, movingSpeed, gender);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "wolf";
	}

	@Override
	void makeSound() {
		System.out.println("The "+this+" howls at the moon.");
		
	}

	@Override
	void move() {
		System.out.println("The "+this+" seems a bit confused after you poke "+gender.thirdObject()+".");
		
	}
	
}
