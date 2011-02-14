package net.azib.java.students.t103781;
import java.math.BigInteger;

 /* Created by IntelliJ IDEA.
 User: Robert Kullamaa 103781IASB21  */

public class FibonacciClass {
    public static void main(String[] args) {

        BigInteger first= new BigInteger("1");
        BigInteger second= new BigInteger("1");
        BigInteger sum= new BigInteger("0");
        int counter=2;
        System.out.println("0=0");
        System.out.println("1=1");
        System.out.println("2=1");
        do{
            sum = first.add(second);
            first=second;
            second=sum;
            counter++;
            System.out.println(counter + "=" + sum);
        }while(counter<100);
    }
}