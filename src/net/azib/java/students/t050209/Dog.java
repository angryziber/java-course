package net.azib.java.students.t050209;

/**
 * Dog
 *
 * @author t050209
 */
public class Dog {
  private String name;
  private Byte age = 1;
  
  public String getName() {
	  return name;
  }
  
  public void GrowUp() {
	  age = age++;
  }
  
  public Dog(String name) {           /*konstruktor*/
	  this.name = name;
  }

  public Dog(Byte age) {           /*konstruktor*/
	  this.age = age;
  }
}
