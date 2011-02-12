package net.azib.java.students.t103758;

public class Dog {
    int numOfLegs;
    String name = "Milo";
    
    public void bark(int numOfBarks) {
  while(0 != numOfBarks){
      System.out.println("woof! ");
      numOfBarks--;
      }
  }
    
    public void sayName(){
      System.out.println("Hi my name is " + this.name);
    }
    public void reName (String newName){
      this.name = newName;
    }
  }
