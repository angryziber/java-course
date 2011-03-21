package net.azib.java.students.t104950;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 17.02.11
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {

   //public long a;
   //public long b;
  // public long count;
    //int index;

    public BigInteger Calculate(int index) {
//mitmeni teha -> index
       BigInteger result,a,b;
        int count;
        for (a=BigInteger.ZERO, b=BigInteger.ONE, count = 0, result=BigInteger.ZERO; count < index-1; count++) {
            result = a.add(b);
            a = b;
            b=result;
        }
        return result;
    }


}

