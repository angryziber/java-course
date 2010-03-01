package net.azib.java.lessons.basic;

/**
 * Dog
 *
 * @author anton
 */
@Todo("Rewrite it!!!")
public class Dog extends Pet implements StickCatcher {
	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public String getSound() {
		return "Woof";
	}

	@Override
	public void catchStick() {
		System.out.println("run, run, see a stick, grab it, return it");
	}

	@Override
	public String toString() {
		return "Dog named " + getName();
	}

	@Override
	public boolean equals(Object that) {
		if (that == null || !(that instanceof Dog))
			return false;
		
		return ((Dog)that).getName().equals(this.getName());
	}

	@Override
	public int hashCode() {
		return 1;
	}
}
