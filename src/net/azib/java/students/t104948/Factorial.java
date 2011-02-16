package net.azib.java.students.t104948;

import java.math.BigInteger;

public class Factorial {
    int n;
    public String doFactorial(){
        int i;
        Integer j;
        BigInteger fact;
        BigInteger temp;
        fact = new BigInteger("1");
        if(n==0){
            return fact.toString();
        }
        else{
            for(i=0; i<n; i++){
            j=i+1;
            temp = new BigInteger(j.toString());
            fact = fact.multiply(temp);
            }
        return fact.toString();
        }
    }
}
