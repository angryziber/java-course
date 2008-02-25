package net.azib.java.students.t030611.homework;

/**
 * MyPets
 * 
 * @author Jekaterina
 */
public class MyPets {
	public static void main(String[] args) {	
		Cat firstCat=new Cat("Alisa","siamese", 5);
		Cat secondCat=new Cat("Persik","none", 2);
		Dog myDog=new Dog("Tuzik","black",  5);
		Animal array[]={ firstCat, secondCat, myDog};
		
		for(Animal a: array){
			System.out.println(a);
		}
		
	}
}
