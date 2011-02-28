package net.azib.java.students.t110051.Lesson3;

public class AnimalDemo {

	public static void main(String[] args) {
		 Animal[] animalArray = new Animal[5];
		animalArray[0] = new Sheep();
		animalArray[1] = new Dog();
		animalArray[2] = new Cat();
		animalArray[3] = new Cow();
		animalArray[4] = new Hedgehog();
		for( Animal i : animalArray){
			System.out.println("Animal " + i.name + " is in the array. And it makes sound " + i.makeSound()+ " It is "+ i.age
		+ " years old. It's sex is " +i.sex +".");
		}


	}
}
