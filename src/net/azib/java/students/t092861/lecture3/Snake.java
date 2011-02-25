/**
 * @author Stanislav / 092861
 * 
 */
public class Snake extends Pet {

	boolean venomous;

	public Snake(String taxonomy, String status, String habitats, int weight,
			String name, String colour, boolean hasOwner, int age,
			boolean venomous) {
		super(taxonomy, status, habitats, weight, name, colour, hasOwner, age);
		this.venomous = venomous;
	}

	@Override
	public String toString() {
		if (venomous) {
			return super.toString() + " | venomous";
		} else
			return super.toString() + " | non-venomous";
	}

	@Override
	String makeSound() {
		return "The snake is not making a sound";
	}
}
