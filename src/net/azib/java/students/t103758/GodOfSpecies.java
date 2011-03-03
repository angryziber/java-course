package net.azib.java.students.t103758;
 /**
   * @param args
   */
public class GodOfSpecies {

  public static void main (String[] args) {
    System.out.println("God said: let there be light!");
    
    Dog koer = new Dog("Snoopy");
    koer.makeSound();
    
    koer.gotOneYearOlder();
    koer.gotOneYearOlder();
    
    System.out.println(koer.getName() + " is " + koer.getAge() + "years old.");
    
    Cat kass = new Cat("Tom");
    System.out.print( kass.getName() + " says ");
    kass.makeSound();
    
    kass.giveName("Ike");
    System.out.println("Cat was given a new name. He's now called " + kass.getName());
    
    koer.wantsToTakeADump();
    kass.wantsToTakeADump();
  }

}
