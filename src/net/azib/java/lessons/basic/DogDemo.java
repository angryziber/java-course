package net.azib.java.lessons.basic;

/**
 * DogDemo
 *
 * @author anton
 */
public class DogDemo {
	int i;
	static int si;
	
	public static void main(String[] args) {
		si = 2;
		
		Dog dog = new Dog();
		System.out.println(dog.age);
		
		final Dog d = new Dog();
		d.name = "Sharik";
		Dog.age = 1;
		
		Dog d2 = new Dog();
		Dog.age = 2;
		
		System.out.println(d.age);
	}
}
