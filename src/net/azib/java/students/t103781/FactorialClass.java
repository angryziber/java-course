package net.azib.java.students.t103781;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Robert Kullamaa 103781IASB21
 */
public class FactorialClass {
    public static BigInteger getFactorial(int index){

        BigInteger n1 = new BigInteger("1");
        BigInteger answer = new BigInteger("1");

        for(int i=1;i<index;i++){
            answer = answer.multiply(n1.add(BigInteger.valueOf(i)));
        }
        return answer;
    }
}
