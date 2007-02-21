package net.azib.java.students.t030632;

/**
 * Animal
 *
 * @author Toni
 */
public abstract class Animal {
	private String name ;
	private byte age ;
	
	public Animal(String name){
		this.name = name;
		this.age = 1;
	}
	
	public Animal(String name, byte age){
		this.name = name;
		this.age = age;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	public void growUp() {
		age++;
	}
	
	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}

	@Override
	public String toString() {
		
		return "I am "+getType()+", my name is "+name+", I am "+age+" years old";
	}
	public abstract String getType();

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object other) {
		if (other == null||!(other instanceof Dog))
			return false;
		// TODO Auto-generated method stub
		return this.getName().equals(((Dog)other).getName())&& this.getClass().equals(other.getClass()) ;
	}

}
