package net.azib.java.students.t050545.hometasks.animal;


/**
 * Cat
 *
 * @author libricon
 */
public class Cat extends Animal {
	Cat(String name, int age){ 
		super(name, age);
	}

	public void makeSound() {
		System.out.println("Cats are mewing !!!");
	}

	public void eat() {
		System.out.println("Cats like Wiskas and milk");
	}
	
	@Override public String toString() {
		return "Cat's name is "+getName()+" and it's "+getAge();
	}

}
