package net.azib.java.students.t110013.hometask2;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 24.02.11
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
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
