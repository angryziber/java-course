package net.azib.java.lessons.basic;

/**
 * Master - the keeper of {@link Animal}s.
 *
 * @author anton
 */
public class Master {
	public static void main(String[] args) {
		Animal a = new Dog("Sharik");
		Animal b = new Cat("Murzik");
		
		a.growUp();
		
		System.out.println("I have two animals:\n" + a + " and\n" + b);
		
		a.makeSound();
		b.makeSound();
				
		try {
			Animal c = (Animal) a.clone();
			c = null;
			System.out.println(c);
			System.out.println(c.equals(a));
		}
		catch (CloneNotSupportedException e) {
			
		}
		finally {
			
		}
			
	}

}
