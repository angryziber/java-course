package net.azib.java.students.t110013.hometask1;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 12.02.11
 * Time: 13:31
 */
public class Factorial {
    private int factorialIndex;
    private BigInteger factorialValue;

    public Factorial(int receivedIndex) {
        if (receivedIndex < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed!");
        }
        factorialIndex = receivedIndex;
    }

    public BigInteger getValue() {
        if (factorialValue == null) {
            factorialValue = BigInteger.ONE;
            if (factorialIndex != 0) {
                for (int i = 1; i <= factorialIndex; i++) {
                    factorialValue = factorialValue.multiply(BigInteger.valueOf(i));
                }
            }
        }
        return factorialValue;
    }

    public int getIndex() {
        return factorialIndex;
    }

    public String toString() {
        return factorialIndex + "! = " + getValue();
    }
}
