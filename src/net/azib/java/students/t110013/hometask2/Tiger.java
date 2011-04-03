package net.azib.java.students.t110013.hometask2;

/**
 * @author Vadim
 */
public class Tiger extends Animal {

	public Tiger(int age) {
		setAge(age);
	}

	public String makeRoar() {
		return "Roar!";
	}

	public String toString() {
		return "A " + (getAge() > 1 ? getAge() + " year" : "year") + " old tiger: " + makeRoar();
	}
}
