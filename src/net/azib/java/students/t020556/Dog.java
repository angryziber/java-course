package net.azib.java.students.t020556;

/**
 * Dog
 *
 * @author t020556
 */
public class Dog 
	extends Animal
	implements Comparable<Dog>
{

	/**
	 * @param name
	 * @param age
	 */
	public Dog(String name, byte age) {
		super(name, age);
	}

	@Override
	public String getName() {
		return "I'm a " + getType() + " and my name is " + 
		this.name + " I'm " + this.age + "years old";
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t020556.Animal#getType()
	 */
	@Override
	public String getType() {
		return "Dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Dog o) {
		if(this.getClass() == o.getClass()){
			return 0;
		}
		return -1;
	}
}
