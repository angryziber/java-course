package net.azib.java.students.t105870.Lecture2;

import java.math.BigInteger;

public class Fibonacci {
    public BigInteger launch(int count){
        BigInteger answer, aNumber, bNumber;

        aNumber = BigInteger.valueOf(1);
        bNumber = BigInteger.valueOf(1);
        answer = BigInteger.ZERO;

        if(1 == count){return BigInteger.ONE;}
        if(0 == count){return BigInteger.ZERO;}
        else{
            while(0 != count){
                answer = aNumber.add(bNumber);
                aNumber = bNumber;
                bNumber = answer;
                count--;
            }
        }
        return answer;
    }
}

