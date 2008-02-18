package net.azib.java.students.t001370.lectures.lec2;

/**
 * Dog
 *
 * @author t001370
 */
public class Dog {
	protected String name;
	
	public Dog(String name){
		super();
		this.name = name;
	}

	String getName(){
		final String newName = "Mega" + name;
		
		return newName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		return "Dog: " + getName();
	}
	
	public static void main(String[] args){
		Dog a = new Dog("Sharik");
		Dog b = new Dog("Tuzik");
		
		System.out.println("I have three dogs " + 
				a.getName() + 
				" and " + b.getName());
	}
}
