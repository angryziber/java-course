package net.azib.java.students.t040719.lessons;

/**
 * Cow
 *
 * @author Administrator
 */
public class Cow extends Animal {
	private int dailyMilkProduction;
	
	public Cow() {
		dailyMilkProduction = calcRndMilkProduction();
		species = "Cow";
	}
	
	public Cow(String name, String breed, int age, int milkProduction) {
		super(name,breed,age,"Cow");
		dailyMilkProduction = milkProduction;
	}
	
	public Cow(String name, String breed, int age) {
		super(name,breed,age,"Cow");
		dailyMilkProduction = calcRndMilkProduction();
		
	}
	
	public int getDailyMilkProduction(){
		return dailyMilkProduction;
	}
	
	public double milkTheCow(){
		return (Math.random()*(dailyMilkProduction - 6) + 6);
	}
	
	private int calcRndMilkProduction(){
		return (int)Math.round(Math.random()*14 +6);
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
