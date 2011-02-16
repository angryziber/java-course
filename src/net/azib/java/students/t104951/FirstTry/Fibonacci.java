package net.azib.java.students.t104951.FirstTry;

/**
 * Created by IntelliJ IDEA.
 * User: Lae
 * Date: 16.02.11
 * Time: 18:20
 * It's never easy..
 */
import java.math.BigInteger;

public class Fibonacci {
    public BigInteger value;

    public void Count(int a){
        BigInteger b = BigInteger.valueOf(1), temp;
        for(value = BigInteger.valueOf(0);a > 0;a--){
            temp = b;
            b = value.add(b);
            value = temp;
        }
    }
}
