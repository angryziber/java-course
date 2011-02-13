/**
 * Created by IntelliJ IDEA.
 * User: Tom
 * Date: 11.02.11
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 */

import java.math.BigDecimal;
import java.math.BigInteger;

//Need to use BigInteger

public class Factorial {
    public void fact(){

    BigInteger factnr = new BigInteger("1");
    BigInteger i = new BigInteger("100");


        for(i.valueOf(100);
            i.compareTo(BigInteger.ZERO)>0;
            i=i.subtract(BigInteger.ONE)){

            factnr = factnr.multiply(i);
        }

    System.out.println("Factorial = "+factnr);
    }
}

