package net.azib.java.students.t104950;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 17.02.11
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class Factorial {

   public BigInteger Calculate(int n) {

        BigInteger result,a,one;
        int count;
	   one=BigInteger.ONE;
        for (a =BigInteger.ONE,  count = 0, result=BigInteger.ONE ; count < n-1; count++) {
            result=result.multiply(a.add(one));
	        a=a.add(one);
	        System.out.println(a);

        }


        return result;
    }
}
