package net.azib.java.students.t040719.lessons;

/**
 * Dog
 *
 * @author Romi
 */
public class Dog extends Animal {
	private int barkingLoudness;
	public final static int MAX_LOUDNESS = 90;
	public final static int MIN_LOUDNESS = 0;
	/**
	 * 
	 */
	public Dog() {
		species = "Dog";
		this.barkingLoudness = calcRndLoudness();
	}
	
	public Dog(String name, String breed, int age) {
		super(name,breed,age,"Dog");
		this.barkingLoudness = calcRndLoudness();
	}

	public Dog(String name, String breed, int age, int loudness) {
		super(name,breed,age,"Dog");
		this.barkingLoudness = (loudness >= MIN_LOUDNESS && loudness <= MAX_LOUDNESS)? loudness : calcRndLoudness();
	}
	
	private int calcRndLoudness(){
		return (int)Math.round(Math.random()*30 + 40);
	}
	
	public int getBarkingLoudness(){
		return barkingLoudness;
	}
	
	public boolean changeBarkingLoudness(int loudnessInDB){
		if (loudnessInDB <= MAX_LOUDNESS && loudnessInDB >= MIN_LOUDNESS){
			barkingLoudness = loudnessInDB;
			return true;
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#makeSound()
	 */
	@Override
	public void makeSound() {
		System.out.println("Woof!");
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "\nBarking loudness: " + barkingLoudness + " dB";
		return str;
	}
	

}
