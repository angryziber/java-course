package net.azib.java.students.t103758;

public abstract class Pet extends Animal{
  
  protected String name;
  public abstract void wantsToTakeADump ();
  
  public Pet (String newName){
    this.name = newName;
    this.isDomesticated = true;
  }
  
  public void giveName(String newName){
    this.name = newName;
  }

  public String getName () {
    return this.name;
  }
}
