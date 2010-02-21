package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
abstract class Pet extends Animal {
	protected String name;

	public Pet(int age, String name) {
		super(age);
		this.name = name;
	}
}
