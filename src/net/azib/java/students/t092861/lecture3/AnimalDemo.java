package net.azib.java.students.t092861.lecture3;

/**
 * @author Stanislav / 092861
 * 
 */
public class AnimalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal[] animals = new Animal[] {
				new Dog("Labrador Retriever", "not in danger", "Newfoundland",
						50000, "Ralf", "black", true, 3, "Amanda"),

				new Eagle("Bald Eagle", "endangered species", "North America",
						5400, 230),

				new Perch("Golden Perch", "not in danger", "Australia", 1200,
						"Percichthyidae"),

				new Snake("Python Regius", "not in danger", "Africa", 4000,
						"Snaky", "dark brown", false, 5, false) };

		for (Animal animal : animals) {
			System.out.print(animal.toString());
			if (animal instanceof Pet)
				System.out.print(" | " + ((Pet) animal).makeSound());
			System.out.println("");
		}
	}
}
