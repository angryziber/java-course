package net.azib.java.students.t093759.hometasks.second;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 02.03.11
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public class Lion extends Animal {

	private String moustache;

	public Lion(int ageInYears, int weightInKg, int countOfLimbs, String sound) {
		super(ageInYears, weightInKg, countOfLimbs, sound);
		moustache = "Long";
	}

	@Override
	public void makeSound() {
		System.out.println(getSound() + "..." + getSound() + "...");
	}


	@Override
	public void move() {
		System.out.println("Moved like a lion on my own " + getCountOfLimbs() + " limbs.");
	}

	@Override
	public String toString() {
		return super.toString() + " Lion also has " + moustache + " moustache.";
	}
}
