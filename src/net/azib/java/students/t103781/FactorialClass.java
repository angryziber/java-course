package net.azib.java.students.t103781;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Robert Kullamaa 103781IASB21
 */
public class FactorialClass {
    public static BigInteger fact100(){

        BigInteger n1 = new BigInteger("100");
        BigInteger answer = new BigInteger("1");

        for(int i=1;i<100;i++){
            int j=1;
            answer = answer.multiply(n1);
            n1 = n1.subtract(BigInteger.valueOf(j));
        }
        return answer;
    }
}
