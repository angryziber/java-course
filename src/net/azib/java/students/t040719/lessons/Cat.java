package net.azib.java.students.t040719.lessons;

/**
 * Cat
 *
 * @author Romi
 */
public class Cat extends Animal {
	private int lives;
	public final static int MAX_LIVES = 9;

	public Cat() {
		species = "Cat";
		lives = MAX_LIVES;
	}
	
	public Cat(String name, String breed, int age) {
		super(name,breed,age,"Cat");
		this.lives = MAX_LIVES;
	}

	public Cat(String name, String breed, int age, int lives) {
		super(name,breed,age,"Cat");
		this.lives = (lives >= 0 && lives <= MAX_LIVES)? lives: MAX_LIVES;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#makeSound()
	 */
	@Override
	public void makeSound() {
		System.out.println("Meaow!");
	}
	
	public void dieOnce(){
		lives = lives > 0 ? --lives : 0;
	}
	
	public boolean isAlive(){
		return lives > 0 ? true : false;
	}
	public int getLivesLeft(){
		return lives;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "\nLives left: " + lives;
		return str;
	}
	
}
