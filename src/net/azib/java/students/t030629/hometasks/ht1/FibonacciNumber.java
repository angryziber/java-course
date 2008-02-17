package net.azib.java.students.t030629.hometasks.ht1;

import java.math.BigInteger;

/**
 * FibonacciNumber
 * 
 * @author _anton_chepurov
 */
public class FibonacciNumber {
    private BigInteger aBigInteger;
    private BigInteger bBigInteger;
    private BigInteger cBigInteger;
    private int index, auxIndex;

    /**
     * @param index index of the Fibonacci number to be calculated
     * @throws Exception if the index is negative
     */
    public FibonacciNumber(int index) throws Exception {
        if (index < 0) {
            throw new Exception("Fibonacci number cannot be calculated for a negative index. " +
                    "Requested index: " + index);
        }
        this.index = auxIndex = index;
        aBigInteger = bBigInteger = BigInteger.ONE;
    }

    public int getIndex(){
    	return index;
    }

    public BigInteger getValue() {

        if (cBigInteger != null) {
            return cBigInteger;
        } else if (auxIndex == 0) {
            return BigInteger.ZERO;
        } else if (auxIndex == 1 || auxIndex == 2) {
            return BigInteger.ONE;
        }

        auxIndex -= 2;
        return calculateFibonacci();

    }
    
    private BigInteger calculateFibonacci() {

        cBigInteger = aBigInteger.add(bBigInteger);
        aBigInteger = bBigInteger;
        bBigInteger = cBigInteger;
        auxIndex--;
        return auxIndex == 0 ? cBigInteger : calculateFibonacci();

    }

    public static void main(String[] args) {
        try {

            FibonacciNumber fibNumber = new FibonacciNumber(100);
            System.out.println(fibNumber.getIndex() + "th: " + fibNumber.getValue());
            System.out.println(fibNumber.getIndex() + "th: " + fibNumber.getValue());

            /* http://en.wikipedia.org/wiki/Fibonacci_number */
            for (int index = 0; index < 15; index++) {
            	fibNumber = new FibonacciNumber(index);
                System.out.println(index + "th: " + fibNumber.getValue());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
