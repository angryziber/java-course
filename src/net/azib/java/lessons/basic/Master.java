package net.azib.java.lessons.basic;

/**
 * Master - the keeper of {@link Animal}s.
 *
 * @author anton
 */
public class Master {
	public static void main(String[] args) {
		Object a = new Dog("Sharik");
		Object b = new Cat("Murzik");
		
		System.out.println("I have two animals:\n" + a + " and\n" + b);
	}

}
