package net.azib.java.students.t020632;

/**
 * Dog
 *
 * @author t020632
 */
public class Dog extends Animal{

	/**
	 * @param name
	 */
	public Dog(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getName(){
		return "Dog " + super.getName();
	}
	


	/* (non-Javadoc)
	 * @see net.azib.java.students.t020632.Animal#getType()
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}

	
}
