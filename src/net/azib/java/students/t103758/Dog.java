package net.azib.java.students.t103758;

public class Dog extends Pet{
    public Dog(String newName) {
    super(newName);
  }

    public void makeSound() {
      System.out.println("woof! ");
    }

    @Override
    public void wantsToTakeADump () {
      System.out.println("Bark - bark! - Take me out side for a walk");      
    }
  }

