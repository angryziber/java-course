package net.azib.java.students.t040719;

/**
 * Dog
 *
 * @author t040719
 */
public class Dog {
	protected String name;
	/**
	 * @param string
	 *
	public Dog() {
		this.name = "Pauka";
	}
	*/
	public Dog(String name) {
		super();
		this.name = name;
	}

	public String getName(){
		final String newName = "Mega" + name;
		return newName;
	}

	@Override
	public String toString() {
		return "Dog: " + getName();
	}

	public static void main(String[] args) {
		Dog a = new Dog("Muki");
		Dog b = new Dog("Pätu");
		//Dog c = new Dog();
		
		System.out.println("I have three dogs: " + a.getName()
				+ ", " + b.getName());
	}
}
