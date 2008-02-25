package net.azib.java.students.t030611.homework;

/**
 * MyPets
 * 
 * @author Jekaterina
 */
public class MyPets {
	public static void main(String[] args) {	
		Cat firstCat=new Cat("siamese","Alisa", 5);
		Cat secondCat=new Cat("none","Persik", 2);
		Dog myDog=new Dog("black", "Tuzik", 5);
		Animal array[]={ firstCat, secondCat, myDog};
		
		for(Animal a: array){
			System.out.println(a);
		}
		
	}
}
