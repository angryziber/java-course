package net.azib.java.students.t103640;

import java.math.BigInteger;

public class Fibbonacci {
    public BigInteger bigFiba(int i){
              BigInteger habba1 = new BigInteger("1");
              BigInteger habba  = new BigInteger("0");
                BigInteger answer = new BigInteger("0");

               int a;
        for(a=0; a<(i-1); a++){
            answer = habba.add(habba1);
            habba = habba1;
            habba1 = answer;
        }

   return answer;
    }
}
