package net.azib.java.students.t110013.hometask2;

/**
 * @author Vadim
 */
public class Zebra extends Animal {

	public Zebra(int age) {
		setAge(age);
	}

	public String makeNeigh() {
		return "Neigh!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " year" : "year") + " old zebra: " + makeNeigh();
	}
}
