package net.azib.java.students.t020281.hometasks;

/**
 * MyAnimals
 *
 * @author Trial
 */
public class MyAnimals {
public static void main(String[] args) {
	Cow myCow = new Cow("Burenka");
	Doggy myDog = new Doggy("Tuzik");
	Animal myHen = new Hen("Masha");
	
	myHen.setAge(2);
	myDog.setBreed("buldog");
	myCow.setColor("white");
	String[] a = {myDog.toString(), myHen.toString(), myCow.toString()};
	
	
	System.out.println("I've 3 animals. They are ");
	for (String name : a ) {
		System.out.println(name);
	}
	System.out.println(myDog+" gives me "+myDog.getProperty()+". It's breed is "+myDog.getBreed());
	System.out.println(myCow+" gives me "+myCow.getProperty()+". It's of "+myCow.getColor()+" color.");
	System.out.println(myHen+" gives me "+myHen.getProperty()+". It's "+myHen.getAge()+" years old.");
	System.out.println("They make a lot of noise, when see me:");
	System.out.println(myCow+" say ");
	myCow.makeSound();
	System.out.println(myDog+" say ");
	myDog.makeSound();
	System.out.println(myHen+" say ");
	myHen.makeSound();
	
	
}
}
