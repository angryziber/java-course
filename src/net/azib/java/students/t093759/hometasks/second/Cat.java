package net.azib.java.students.t093759.hometasks.second;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 02.03.11
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public class Cat extends Pet {

	private String mustache;

	public Cat(int ageInYears, int weightInKg, int countOfLimbs, String sound, String name) {
		super(ageInYears, weightInKg, countOfLimbs, sound, name);
		mustache = "short";
	}

	@Override
	public void makeSound() {
		System.out.println(getSound() + "..." + getSound() + "...");
	}

	@Override
	public void move() {
		System.out.println("Moved like a cat on my own " + getCountOfLimbs() + " limbs.");
	}

	@Override
	public String toString() {
		return super.toString() + " Cat also has " + mustache + " mustache.";
	}
}
