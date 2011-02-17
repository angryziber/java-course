package net.azib.java.students.t103758;

import java.math.BigInteger;

public class Fibonacci {
  public BigInteger calculate(int count){
    BigInteger answer, fNumber, sNumber;
    
    fNumber = BigInteger.valueOf(1);
    sNumber = BigInteger.valueOf(1);
    answer = BigInteger.ZERO;
    
    if (1 == count){return BigInteger.ONE;}
    if (0 == count){return BigInteger.ZERO;}
    else {
          while(0 != count){
          answer = fNumber.add(sNumber);
          fNumber = sNumber;
          sNumber = answer;
          count--;
          }
    }
    return answer;
  }
}
