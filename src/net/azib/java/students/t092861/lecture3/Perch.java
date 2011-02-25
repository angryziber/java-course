/**
 * @author Stanislav / 092861
 * 
 */
public class Perch extends Animal {

	String family;

	public Perch(String taxonomy, String status, String habitats, int weight,
			String family) {
		super(taxonomy, status, habitats, weight);
		this.family = family;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + getFamily();
	}

	public String getFamily() {
		return family;
	}

}
