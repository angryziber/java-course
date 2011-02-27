package net.azib.java.students.t092855;


import java.math.BigInteger;

public class Fibonacci {

	/**
	 *  Calculates number in specified position in the fibonacci sequence.
	 * @param index     Sequence number in the fibonacci sequence. Should be positive integer. Sequence starts with no. 1.
	 * @return          Number corresponding to the index in the fibonacci sequence.
	 *                  -1 when input parameter is non-positive
	 */
  public BigInteger getNumber(int index)
  {
      BigInteger result = new BigInteger("-1");

      if(index < 1)
          return result;

      result = new BigInteger("0");
      BigInteger prevValue = new BigInteger("1");

      for (int i = 1; i < index; i++) {
          result = result.add(prevValue);
          prevValue = result.subtract(prevValue);
      }

      return result;
  }

}
