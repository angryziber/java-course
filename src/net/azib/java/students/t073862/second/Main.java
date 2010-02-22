package net.azib.java.students.t073862.second;

/**
 * Main
 *
 * @author Pets
 */
public class Main {
	public static void main(String[] args) {
		Dog d = new Dog(12,"Dog name");
		Cat c = new Cat(1,"Cat name");
		c.setMale(false);
		Animal[] arr = new Animal[2];
		arr[0] = d;
		arr[1] = c;
		for(Animal a : arr) {
			System.out.println(a.toString());
		}
	}
}
