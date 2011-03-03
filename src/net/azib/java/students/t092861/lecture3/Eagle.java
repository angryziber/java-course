package net.azib.java.students.t092861.lecture3;

/**
 * @author Stanislav / 092861
 * 
 */
public class Eagle extends Animal {

	int wingspan;

	public Eagle(String taxonomy, String status, String habitats, int weight,
			int wingspan) {
		super(taxonomy, status, habitats, weight);
		this.wingspan = wingspan;
	}
	
	@Override
	public String toString() {
		return super.toString() + " | " + getWingspan();
	}

	public int getWingspan() {
		return wingspan;
	}
}
