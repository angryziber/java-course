package net.azib.java.students.t040750.homework.lesson2;

/**
 * Farm
 *
 * @author karpo
 */
public class Farm {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];
		
		animals[0] = new Dog("Pluto","4","brown");
		animals[1] = new Cow("Maasi","2","black-white");
		animals[2] = new Chicken("Chick","0.5","white");
		
		for (Animal animal:animals) {	
			System.out.println(animal);
		}
	}

}
