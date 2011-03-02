package net.azib.java.students.t093759.hometasks.second;

/**
 * Created by IntelliJ IDEA.
 * User: dionis
 * Date: 02.03.11
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public class AnimalDemo {
	public static void main(String[] args) {
		new AnimalDemo().run();
	}

	private void run() {
		Animal[] animals = new Animal[]{
					new Dog(12, 30, 4, "Rrr", "Sharky"),
					new Dog(12, 30, 4, "Grgrgr", "Doggy"),
					new Lion(30, 200, 4, "ArrggHHH"),
					new Cat(1, 15, 4, "Mrmäo", "Kitty"),
					new Cat(12, 5, 3, "Mrmäo!!!", "Old Tom"),
			};

		for (Animal animal : animals) {
			System.out.println(animal);
			System.out.print("Making sound: ");
			animal.makeSound();
			System.out.print("Lets move a little bit: ");
			animal.move();
			if (animal instanceof Pet) {
				System.out.println(animal.getClass().getSimpleName().toString()
						+ " named " + ((Pet) animal).getName());
			}
			System.out.println("-----------");
		}
	}
}
