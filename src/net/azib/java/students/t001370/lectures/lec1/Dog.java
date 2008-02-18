package net.azib.java.students.t001370.lectures.lec1;

/**
 * Dog
 *
 * @author t001370
 */
public class Dog {
	String name;
	
	public Dog(){
		this.name = "Unnamed";
	}

	public Dog(String name){
		this.name = name;
	}

	String getName(){
		final String newName = "Mega" + name;
		
		return newName;
	}
	
	public static void main(String[] args){
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		Dog c = new Dog();
		
		System.out.println("I have three dogs " + 
				a.getName() + 
				" and " + b.getName() + 
				" and " + c.getName());
	}
}
