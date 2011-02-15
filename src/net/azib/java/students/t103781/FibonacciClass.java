package net.azib.java.students.t103781;
import java.math.BigInteger;

 /* Created by IntelliJ IDEA.
 User: Robert Kullamaa 103781IASB21  */

public class FibonacciClass {
    public static BigInteger Show100(){

        BigInteger first= new BigInteger("1");
        BigInteger second= new BigInteger("1");
        BigInteger sum= new BigInteger("0");
        int counter=2;
        do{
            sum = first.add(second);
            first=second;
            second=sum;
            counter++;
        }while(counter<100);
        return sum;
    }
}