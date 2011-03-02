package net.azib.java.students.t093759.hometasks.second;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 02.03.11
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class Animal {
	private int ageInYears;
	private int weightInKg;
	private int countOfLimbs;
	private String sound;


	public Animal(int ageInYears, int weightInKg, int countOfLimbs, String sound) {
		this.ageInYears = ageInYears;
		this.weightInKg = weightInKg;
		this.countOfLimbs = countOfLimbs;
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	public int getAgeInYears() {
		return ageInYears;
	}

	public int getCountOfLimbs() {
		return countOfLimbs;
	}

	public int getWeightInKg() {
		return weightInKg;
	}

	public abstract void move();

	public abstract void makeSound();

	@Override
	public String toString() {
		return "Animal with " + countOfLimbs + " limbs, age: " + ageInYears + " year(-s), weight:"
				+ weightInKg + " kg, sound: " + sound + ".";
	}
}
