/**
 * @author Stanislav / 092861
 * 
 */
public abstract class Pet extends Animal {
	String name;
	String colour;
	boolean hasOwner;
	int age;

	public Pet(String taxonomy, String status, String habitats, int weight,
			String name, String colour, boolean hasOwner, int age) {
		super(taxonomy, status, habitats, weight);
		this.name = name;
		this.colour = colour;
		this.hasOwner = hasOwner;
		this.age = age;
		transportationCost(this.weight);
	}

	abstract String makeSound();

	public String getName() {
		return name;
	}

	public String getColour() {
		return colour;
	}

	public boolean isHasOwner() {
		return hasOwner;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return getName() + " | " + getAge() + " | " + getColour() + " | "
				+ getTaxonomy() + " | " + getStatus() + " | " + getHabitats()
				+ " | " + getWeight() + " | " + getTransportCost();
	}
}
