package net.azib.java.students.t050209;

/**
 * Animal
 *
 * @author t050209
 */
public abstract class Animal {
	  private String name;
	  private byte age = 1;
	  
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
	  
	  public abstract String getType();

	@Override
	public final String toString() {
		// TODO Auto-generated method stub
		return "I am " + getType() + ", my name is " + name + 
		       ", I am " + age + " years old";
	}
	  
	  
}
