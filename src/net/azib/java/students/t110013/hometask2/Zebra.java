package net.azib.java.students.t110013.hometask2;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 24.02.11
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
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
