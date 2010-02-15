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
		
		Pet dog = new Dog("Muku", 1);
		System.out.println(dog.getAge());
		
		final Pet d = new Dog("Sharik", 1);
		
		Pet dog2 = new Dog("Sharik2", 2);
		
		System.out.println(d.getAge());
		
		System.out.println(dog);
		System.out.println(dog2);
		System.out.println(dog == dog2);
		System.out.println(dog.equals(new Dog("Muku", 100)));
	}
}
