package net.azib.java.students.t103758;

  /**
   * @author Mihkel Pukk
   */

public class NumberDemo {
  
  static int thNumber = 100; 

  public static void main (String[] args) {
    
    Fibonacci fibo = new Fibonacci();
    System.out.println(thNumber + "th number in fibonacci sequence is " + fibo.calculate(thNumber));
    
    Factorial faco = new Factorial();
    System.out.print(thNumber + "th number in factorial sequence is " + faco.calculate(thNumber));

  }

}
