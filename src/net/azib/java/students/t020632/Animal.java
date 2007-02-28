package net.azib.java.students.t020632;

/**
 * Animal
 *
 * @author t020632
 */
public abstract class Animal implements Comparable<Animal>, IAnimal {
	private String name;
	private byte age;
	
	public Animal(String name){
		this.name = name;
	}
	
	public Animal(String name, byte age){
		this.name = name;
		this.age = age;
	}
	
	
	public byte growUp(){
		age++; 
		return age;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t020632.IAnimal#getName()
	 */
	public String getName(){
		return name;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t020632.IAnimal#getAge()
	 */
	public byte getAge(){
		return age;
	}
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t020632.IAnimal#getType()
	 */
	public abstract String getType();
	
	public final String toString(){
		return "I am " + getType() + ", my name is " + name + "I am " + age + " years old";
	}
	
	public boolean equals(Object other){
		if(other == null || ! (other instanceof Animal))
			return false;
		
		return this.getName().equals(((IAnimal)other).getName()) && this.getClass() == other.getClass();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getName().hashCode() + getClass().hashCode();
	}
	
	
	
}
