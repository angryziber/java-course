package net.azib.java.students.t092861.lecture3;

/**
 * @author Stanislav / 092861
 * 
 */
public abstract class Animal {
	String taxonomy;
	String status;
	String habitats;
	int weight;
	double transportCost;

	public Animal(String taxonomy, String status, String habitats, int weight) {
		this.taxonomy = taxonomy;
		this.status = status;
		this.habitats = habitats;
		this.weight = weight;
		transportationCost(this.weight);
	}

	public void transportationCost(int weight) {
		this.transportCost = (weight / 1000) * 5.55;
	}

	public String getTaxonomy() {
		return taxonomy;
	}

	public String getStatus() {
		return status;
	}

	public String getHabitats() {
		return habitats;
	}

	public int getWeight() {
		return weight;
	}

	public double getTransportCost() {
		return transportCost;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTaxonomy() + " | " + getStatus() + " | " + getHabitats()
				+ " | " + getWeight() + " | " + getTransportCost();
	}
}
