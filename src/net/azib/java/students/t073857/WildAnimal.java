package net.azib.java.students.t073857;

/**
 * WildAnimal
 *
 * @author Joonas Vali
 */
public abstract class WildAnimal extends Animal{

	/**
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public WildAnimal(int weight, int age, int movingSpeed, Gender gender) {
		super(weight, age, movingSpeed, gender);
		// TODO Auto-generated constructor stub
	}
	
	public void runFromIt(){
		System.out.println("You run from a "+this+", "+gender.thirdSubject()+" starts to chase you and you have a lots of fun with "+gender.thirdObject()+".");
	}

}
