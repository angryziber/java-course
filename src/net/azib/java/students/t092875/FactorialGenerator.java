package net.azib.java.students.t092875;

import java.math.BigInteger;

/**
 * FactorialGenerator
 *
 * @author Mihhail
 */
public class FactorialGenerator implements NumbersGenerator {

	@Override
	public BigInteger getNthNumber(int n) {
		if(n < 0){
			return null;
		}else{
			switch(n){
				case 0: return BigInteger.ONE;
				default: return generateNthFactorial(n);
			}
		}
	}
	
	private BigInteger generateNthFactorial(int n){
		BigInteger temp = BigInteger.ONE;
		for(int i=1; i<n+1; i++){
			temp = temp.multiply(new BigInteger(""+i));
		}
		return temp;
	}

}
