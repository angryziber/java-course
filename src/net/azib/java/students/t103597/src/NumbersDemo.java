import sun.font.CreatedFontTracker;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Tom
 * Date: 11.02.11
 * Time: 1:13
 * To change this template use File | Settings | File Templates.
 */

public class NumbersDemo {
    public static void main(String[] args){

        //BigInteger fibnr, factnr;

        // USER CAN CHOOSE THE INDEX FOR THE NUMBERS
        //System.out.println("Enter the index of the Fibonacci & Factorial numbers you wish to see: ");
        //Scanner index = new Scanner(System.in);
        //System.out.println("You chose nr: "+ index.nextLine());

        // CREATES OBJECTS OF THE CLASSES USED
        Factorial factObject = new Factorial();
        Fibonacci fibObject = new Fibonacci();

        // USES SPECIFIED OBJECTS FROM CHOSEN CLASSES
        fibObject.fib();
        factObject.fact();

        //System.out.println(factnr);
        //System.out.println(x);

        // BRING VALUES AND OUTPUT RESULTS


        }
}

