package net.azib.java.students.t104950;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 25.02.11
 * Time: 9:51
 * To change this template use File | Settings | File Templates.
 */


public class FamilyAndOtherAnimals {
    public static void main(String[]args){

         Cat Albert= new Cat(2,"Albert",15);
        System.out.println("CAt made sound: ");
         Albert.makeSound();
        System.out.println("Cat age is : " + Albert.getAge()) ;
        System.out.println("Cat mouse count is: " + Albert.getMouseCount());
        System.out.println("Cat name is: " + Albert.getName());


}

        }
