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
	
	public void description(){
		System.out.println(getName()+" is "+getAge()+" years old. "+gender.thirdSubject()+" weights about "+getWeight()+" kilograms " +
				"and moves with an average speed of "+getMovingSpeed()+" km/h.");
	}
	
	public String getName(){
		return name;
	}	
	
	public void changeName(String name){
		this.name = name;
	}
	
	abstract void stroke();
	
}
