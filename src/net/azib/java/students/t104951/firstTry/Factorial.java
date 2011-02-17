package net.azib.java.students.t104951.firstTry;

/**
 * Created by IntelliJ IDEA.
 * User: Lae
 * Date: 16.02.11
 * Time: 18:22
 * It's never easy..
 */
import java.math.BigInteger;

public class Factorial {
    public BigInteger value;

    public void count(int a){
       for(value = BigInteger.valueOf( a ), a--;a > 0;a--)
           value = value.multiply(BigInteger.valueOf( a ));
   }
}
