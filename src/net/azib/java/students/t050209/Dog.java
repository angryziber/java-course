package net.azib.java.students.t050209;

/**
 * Dog
 *
 * @author t050209
 */
public class Dog extends Animal implements Comparable<Dog>{

	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}

	public Dog(String name) { /* ctrl + 1 abil */
		super(name);
		// TODO Auto-generated constructor stub
	}

	public Dog(byte age) {
		super(age);
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return "Dog: " + super.getName(); /* lihtsalt name ei saa, sest private. vaja sel juhul protected*/
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Dog";
	}	
}
