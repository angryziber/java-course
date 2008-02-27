package net.azib.java.students.t040719.lessons;

/**
 * Cow
 *
 * @author Administrator
 */
public class Cow extends Animal {
	private int dailyMilkProduction;
	public final static int MIN_PRODUCTION = 0;
	public final static int MAX_PRODUCTION = 40;
	
	public Cow(String name, String breed, int age, int milkProduction) {
		super(name,breed,age);
		dailyMilkProduction = (milkProduction <= MAX_PRODUCTION && milkProduction >= MIN_PRODUCTION)? milkProduction : calcRndMilkProduction();
	}
	
	public Cow(String name, String breed, int age) {
		super(name,breed,age);
		dailyMilkProduction = calcRndMilkProduction();
	}
	
	public int getDailyMilkProduction(){
		return dailyMilkProduction;
	}
	
	public float milkTheCow(){
		return (float)Math.random()*dailyMilkProduction;
	}
	
	private int calcRndMilkProduction(){
		return (int)Math.round(Math.random()*14 + 6);
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#makeSound()
	 */
	@Override
	public void makeSound() {
		System.out.println("Moo!");
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "\nDaily milk production: " + dailyMilkProduction +" liters";
		return str;
	}
	
	
}
