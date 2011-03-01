/**
 * @author Stanislav / 092861
 * 
 */
public class Dog extends Pet {

	String ownersName;

	public Dog(String taxonomy, String status, String habitats, int weight,
			String name, String colour, boolean hasOwner, int age,
			String ownersName) {
		super(taxonomy, status, habitats, weight, name, colour, hasOwner, age);
		if (hasOwner) {
			this.ownersName = ownersName;
		} else {
			this.ownersName = "looks for warm home";
		}
	}

	@Override
	public String toString() {
		if(hasOwner){
			return super.toString() + " | Owner: " + getOwnersName();
		}
		else 
			return super.toString();

	}

	@Override
	String makeSound() {
		return "The dog is barking";
	}

	public String getOwnersName() {
		return ownersName;
	}
}
