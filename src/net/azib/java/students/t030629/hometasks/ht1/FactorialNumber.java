package net.azib.java.students.t030629.hometasks.ht1;

import java.math.BigInteger;

/**
 * FactorialNumber
 * 
 * @author _anton_chepurov
 */
public class FactorialNumber {
    private final int value;
    private BigInteger factorialValue;

    public FactorialNumber(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Factorial can be calculated for non-negative numbers only. " +
                    "Requested number: " + value);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private BigInteger getFactorial() {
        if (factorialValue == null) {
            calculateFactorial();
        }
        return factorialValue;
    }

    private void calculateFactorial() {
        factorialValue = BigInteger.ONE;
        if (value != 0) {
            for (int index = 1; index <= value; index++) {
                factorialValue = factorialValue.multiply(BigInteger.valueOf(index));
            }
        }
    }

    public static void main(String[] args) {
        try {
            FactorialNumber factorialNumber = new FactorialNumber(100);
            System.out.println(factorialNumber.getValue() + "th: " + factorialNumber.getFactorial());
            System.out.println(factorialNumber.getValue() + "th: " + factorialNumber.getFactorial());

            for (int number = 0; number < 100; number++) {
                factorialNumber = new FactorialNumber(number);
                System.out.println(factorialNumber.getValue() + "th: " + factorialNumber.getFactorial());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
