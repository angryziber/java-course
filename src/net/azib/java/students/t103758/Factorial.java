package net.azib.java.students.t103758;

import java.math.BigInteger;

public class Factorial {
  public BigInteger launch (int count){
    
    BigInteger bigCount = BigInteger.valueOf(count);
    BigInteger fNumber = BigInteger.ONE;
    
    while(0 < bigCount.intValue()){
      fNumber = fNumber.multiply(bigCount);
      bigCount = bigCount.subtract(BigInteger.ONE);
      }
    
    return fNumber;
  }
}
