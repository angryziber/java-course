package net.azib.java.students.t093759.hometasks.second;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 02.03.11
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pet extends Animal {
	private String name;

	public Pet(int ageInYears, int weightInKg, int countOfLimbs, String sound, String name) {
		super(ageInYears, weightInKg, countOfLimbs, sound);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return super.toString() + " Pet, name: " + name + ".";
	}
}
