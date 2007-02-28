package net.azib.java.students.t030675;



public class Dog extends Animal implements Comparable<Dog>, IAnimal{

	public Dog(String name) {
		super(name);
	}
	
	public Dog(String name, byte age) {
		super(name, age);
	}



	/* (non-Javadoc)
	 * @see net.azib.java.students.t030675.IAnimal#getName()
	 */
	public String getName() {
		return "Pjos" + super.getName();
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t030675.IAnimal#getType()
	 */
	public String getType(){
		return "Dog";
	}


	public int compareTo(Dog o) {

		return getName().compareTo(o.getName());
	}
	
}