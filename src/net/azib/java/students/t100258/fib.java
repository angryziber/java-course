package net.azib.java.students.t100258;
import java.math.BigInteger;

public class fib {

	public BigInteger main(int n) {
		BigInteger fn;
		fn=BigInteger.ZERO;
		BigInteger fnbig;
		fnbig=BigInteger.ONE;
		BigInteger fnsmall;
		fnsmall=BigInteger.ZERO;
		switch(n){
		case 0:
			return BigInteger.ZERO;
		case 1:
			return BigInteger.ONE;
		default:
		
			for(int i=2;i<n+1;i++)
				{
				fn=fnbig.add(fnsmall);
				fnsmall=fnbig;
				fnbig=fn;
				//System.out.println("F"+i +" = " + fn);
				}
			return fn;
			}
		}
	}


