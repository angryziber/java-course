import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Tom
 * Date: 11.02.11
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 */
public class Fibonacci {
    public void fib(){

        int nr = 100;
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("1");
        BigInteger temp;

        do{
            temp = x.add(y);
            x = y;
            y = temp;
            nr--;
        } while(nr > 0);

        System.out.println("Fibonacci = "+x);
    }
}
