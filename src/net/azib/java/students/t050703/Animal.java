package net.azib.java.students.t050703;

/**
 * Animal
 *
 * @author Leedu
 */
public abstract class Animal {
  private String name;
  private int age;
  
  public Animal(String name, int age)
  {  this.name = name;
     this.age = age;
  }
  
  public String toString()
  {  
	  return getClass().getSimpleName()+" "+ name+" " + age+ " years old";
  }
  
  public abstract void makeSound();
}
