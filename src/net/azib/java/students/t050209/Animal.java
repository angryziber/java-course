package net.azib.java.students.t050209;

/**
 * Animal
 *
 * @author t050209
 */
public abstract class Animal implements Ianimal{
	  private String name;
	  private byte age = 1;
	  
	  /* (non-Javadoc)
	 * @see net.azib.java.students.t050209.Ianimal#getName()
	 */
	public String getName() {
		  return name;
	  }
	  
	  public void GrowUp() {
		  age++;
	  }
	  
	  public Animal(String name) {           /*konstruktor*/
		  this.name = name;
	  }

	  public Animal(byte age) {           /*konstruktor*/
		  this.age = age;
	  }
	  
	  /* (non-Javadoc)
	 * @see net.azib.java.students.t050209.Ianimal#getType()
	 */
	public abstract String getType();

	@Override
	public final String toString() {
		// TODO Auto-generated method stub
		return "I am " + getType() + ", my name is " + name + 
		       ", I am " + age + " years old";
	}

	public boolean equals(Object other) {
		if (other == null || !(other instanceof Animal))
			return false;
		
		return this.getName().equals(((Ianimal)other).getName()) &&
			   this.getClass() == other.getClass();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getName().hashCode() + getClass().hashCode();
	}
	
	
	  
}
