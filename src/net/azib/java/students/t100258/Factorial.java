package net.azib.java.students.t100258;
import java.math.BigInteger;

public class Factorial {

	public BigInteger calcFactorial(int n) {
		BigInteger fa;
		
		fa =BigInteger.ONE;
		
		switch(n){
			case 0:
				return BigInteger.ONE;
			default:
				{
				for(int i=1;i<n+1;i++)
					{
					fa=fa.multiply(BigInteger.valueOf(i));
					//System.out.println(i +"! = " + fa);
					}
				return fa;
				}
			}
		}	
	}


