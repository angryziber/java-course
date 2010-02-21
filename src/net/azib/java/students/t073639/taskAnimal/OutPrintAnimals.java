package net.azib.java.students.t073639.taskAnimal;

/**
 * @author t073639
 * 
 */
public class OutPrintAnimals {
	public static void main(String[] args) {
		Animal[] array = new Animal[4];
		array[0] = new Cat(2, "Kisu");
		array[1] = new Dog(6, "Sharik");
		array[2] = new Cow(3);
		array[3] = new Sheep(1);
		for (Animal animal : array) {
			System.out.println(animal.toString());
		}
	}
}
