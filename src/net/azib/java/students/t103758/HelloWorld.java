/**
 * 
 */
package net.azib.java.students.t103758;

/**
 * @author Mihkel Pukk
 * 
 */
public class HelloWorld {
  
  public static void main (String[] args) {
    System.out.println("Hello World!");
    Dog koer = new Dog();
    
    koer.bark(2);
    koer.sayName();
    koer.reName("snoopy");
    koer.sayName();
}
}