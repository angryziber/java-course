package net.azib.java.students.t103640;

import java.math.BigInteger;

public class Factorial {
      public BigInteger giantFac(int i){
             int a;
             BigInteger answer = new BigInteger(String.valueOf(i));
            BigInteger habba = new BigInteger(String.valueOf(answer.subtract(BigInteger.ONE)));


          for(a=0; a<(i-1); a++){
           answer = answer.multiply(habba);
              habba = habba.subtract(BigInteger.ONE);
          }
       return answer;
      }


}
