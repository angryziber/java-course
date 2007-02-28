package net.azib.java.students.t010687;

/**
 * Animal
 *
 * @author t010687
 */
public abstract class Animal implements IAnimal {
	public String name;
	private int age;
	public Animal (String AnimalName){
		name = AnimalName;
		age = 0;
	}
	public Animal (String AnimalName, int Age){
		name = AnimalName;	
		age = Age;
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t010687.IAnimal#getName()
	 */
	public String getName(){
		return name;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t010687.IAnimal#getAge()
	 */
	public int getAge(){
		return age;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		// TODO Auto-generated method stub
		return "I am " + getType() + " " + name;
	}
	public abstract String getType();
	/**
	 * @param o
	 * @return
	 */
	public int compareTo(IAnimal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
