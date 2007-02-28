package net.azib.java.students.t020544;

/**
 * DogTest
 *
 * @author Julija Kondratjeva
 */
public class DogTest {
	
	public static void main(String[] args) {
		Dog doberman = new Dog("Deik", (byte) 3);
			
		//System.out.println(doberman.getName());
		System.out.println(doberman.hashCode());
		
		//Animal cat = new Animal("Name", (byte) 4);
		//System.out.println(cat.getName());
		
		Dog taksa = new Dog("Deik", (byte) 3);
		//System.out.println(taksa.getName());
		System.out.println(taksa.hashCode());
	
	}

}
