package net.azib.java.students.t105870.Lecture3;

public class AnimalsDemo{

	public static void main(String[] args) {
		Animal animals[] = new Animal[8];
		animals[0] = new Cat();
		animals[1] = new Cat("Bagira","lollipop","miss Crazy",2);
		animals[2] = new Dog();
		animals[3] = new Dog("Rex","Mr. Killer",4);
		animals[4] = new Parrot();
		animals[5] = new Parrot("Coco","Indian boy",7,154);
		animals[6] = new Chicken();
		animals[7] = new Chicken("Ryaba","Vanya",1,250);

		System.out.println("Animals created:\n");

		for(Animal list: animals){
			System.out.println(list);
			System.out.println("This animal sounds like:");
			list.makeSound();
			System.out.println();
		}
	}
}
