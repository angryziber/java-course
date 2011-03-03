package net.azib.java.students.t103758;

public class Cat extends Pet {
    public Cat(String newName){
    super(newName);
  }

    void makeSound () {
      System.out.println("meow ");
    }

    @Override
    public void wantsToTakeADump () {
      System.out.println("I just did it in the litterbox. Go clean up!");
    }
  
}
