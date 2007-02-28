package net.azib.java.students.t020544;

/**
 * SomeStuff
 * 
 * @author Julija Kondratjeva
 */
public class DogStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Dog dobermanDeik = new Dog("Deik", (byte) 3);
		
		dobermanDeik.testInstanceMethod();
		//Animal.testInstanceMethod();
		System.out.println("Name:" + dobermanDeik.getName() + ";  Age:" + dobermanDeik.getAge() + ";");

		for (int i = 0; i < 4; i++) {
			dobermanDeik.growUp();
		}
		System.out.println(dobermanDeik.getName() + " " + dobermanDeik.getAge() + " ;");

		Dog dobermanRex = new Dog("Rex", (byte) 0);

		System.out.println(dobermanRex.getName() + " " + dobermanRex.getAge() + "; ");

		for (int i = 0; i < 4; i++) {
			dobermanRex.growUp();
		}
		System.out.println(dobermanRex.getName() + " " + dobermanRex.getAge() + " ;");

	}
}
