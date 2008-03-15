package net.azib.java.students.t030629.hometasks.ht1;

import java.math.BigInteger;

/**
 * FibonacciNumber
 * 
 * @author _anton_chepurov
 */
public class FibonacciCalculator {
    private BigInteger aBigInteger;
    private BigInteger bBigInteger;
    private BigInteger cBigInteger;
    private int index, auxIndex;

    /**
     * @param index index of the Fibonacci number to be calculated
     * @throws IndexOutOfBoundsException if the specified index is negative
     */
    public FibonacciCalculator(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Fibonacci number cannot be calculated for a negative index. " +
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

}
