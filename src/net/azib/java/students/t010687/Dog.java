package net.azib.java.students.t010687;

/**
 * Dog
 *
 * @author t010687
 */
public class Dog extends Animal implements Comparable<Dog> {

	/**
	 * @param AnimalName
	 */
	public Dog(String AnimalName) {
		super(AnimalName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param AnimalName
	 * @param Age
	 */
	public Dog(String AnimalName, int Age) {
		super(AnimalName, Age);
		// TODO Auto-generated constructor stub
	}
	public String getName(){
		return "Dog: " + super.getName();
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t010687.Animal#getType()
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Dog";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object other) {
		if ((other == null) || ! (other instanceof Dog))
			return false;

		return this.getName().equals(((Dog)other).getName());
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(IAnimal o) {
		return getName().compareTo(o.getName());
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
