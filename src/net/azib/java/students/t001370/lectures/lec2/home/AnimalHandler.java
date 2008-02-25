package net.azib.java.students.t001370.lectures.lec2.home;

/**
 * AnimalHandler
 *
 * @author maksim
 */
public class AnimalHandler {

	static Animal[] animalArray = new Animal[] {new Dog("Doggy", "22.02.2004"),
										 		new Cat("Catty", "23.12.1999"),
										 		new Cock("Cocky", "05.06.1990"),
										 		new Cow("Cowy")};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 0;

		System.out.println("Animals in array:");
		System.out.println("-----------------------------------");
		for (Animal animal: animalArray) {
			System.out.println(++i + " - " + animal);
			System.out.print(animal.getName() + " is making sound like: ");
			animal.makeSound();
			System.out.println("-----------------------------------");
		}

		
		Animal a = new Dog("Sharik");
		Animal b = new Cat("Tuzik");
		System.out.println(a.compareTo(b));

		
		System.out.println("-----------------------------------");
		/*Cloneable c = a;
		System.out.println(a);
		System.out.println(c);*/
		
		
		System.out.println("-----------------------------------");
		Dog d = (Dog)a;
		System.out.println(d);
		System.out.println(((Cat)b).getName());
		a.makeSound();
		b.makeSound();

		System.out.println("-----------------------------------");
		System.out.println(a.equals(a));
		
		Exception e2 = new Exception();
		try{
			Animal e = (Animal)a.clone();
			e = null;
			System.out.println(e);
			System.out.println(e.equals(a));
		}
		catch (Exception e){
			System.out.println("Unknown error: " + e);
		}
		finally{
			//System.out.println("finally");
			e2.printStackTrace();
		}
		/*catch (CloneNotSupportedException e){
			System.out.println("Can't clone ...");
		}
		catch (NullPointerException e){
			e.printStackTrace();
		}*/
		
	}
}
