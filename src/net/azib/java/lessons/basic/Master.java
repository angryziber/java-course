package net.azib.java.lessons.basic;

/**
 * Master
 *
 * @author anton
 */
public class Master {
	public static void main(String[] args) {
		Object a = new Dog("Sharik");
		Object b = new Bulldog("Tuzik");
		
		System.out.println("I have two:\n" + a + " and\n" + b);
	}

}
