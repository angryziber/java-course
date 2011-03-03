package net.azib.java.students.t103758;

public abstract class Animal {
  
  protected int age;
  boolean isDomesticated = false;
  
  abstract void makeSound();
  
  public void gotOneYearOlder(){
      this.age++;
    }

  public int getAge(){
    return this.age;
  }
  
}
