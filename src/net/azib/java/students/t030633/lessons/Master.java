package net.azib.java.students.t030633.lessons;

/**
 * Master
 * 
 * @author t030633
 */
public class Master {

	public static void main(String[] args) {

		Dog a = new Dog("Pontu");
		Object b = new Dog("Tuzik");
		Dog ba = new Bulldog();
		Object bb = new Bulldog("Mad Animal");

		System.out.println("Dogs: " + a + " and " + b);
		System.out.println("Bulldogs: " + ba + " and " + bb);

	}
}
