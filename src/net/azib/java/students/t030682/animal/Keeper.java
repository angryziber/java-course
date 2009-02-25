package net.azib.java.students.t030682.animal;

/**
 * Keeper
 *
 * @author Administrator
 */
public class Keeper {
public static void main(String[] args) {
	Animal[] a = new Animal[8];
	a[0] = new Dog("Tuzik",5,9.0022f);
	a[1] = new Cat("Murzik",2,93.0022f);
	a[2] = new Sheep("Shawn",12,1.0022f);
	a[3] = new Cow("Mayka",1,7.0022f);
	a[4] = new Dog("Sharik",34,911.0022f);
	a[5] = new Cat("Leopold",22,1.0022f);
	a[6] = new Sheep("Ovechko",4,0.0022f);
	a[7] = new Cow("Korovko",6,12.0022f);
	
	for (Animal animal : a) {
		System.out.println(animal);
		animal.makeSound();
		animal.makeThing();
		System.out.println("============");
	}
}
}