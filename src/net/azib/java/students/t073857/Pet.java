package net.azib.java.students.t073857;

/**
 * Pet
 *
 * @author Joonas Vali
 */
public abstract class Pet extends Animal{

	private String name;
	
	/**
	 * @param weight
	 * @param age
	 * @param movingSpeed
	 * @param gender
	 */
	public Pet(String name, int weight, int age, int movingSpeed, Gender gender) {
		super(weight, age, movingSpeed, gender);
		this.name = name;
	}	
	
	public String getName(){
		return name;
	}
	
	public void changeName(String name){
		this.name = name;
	}
	
	abstract void stroke();
	
}
