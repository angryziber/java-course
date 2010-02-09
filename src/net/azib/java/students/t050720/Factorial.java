package net.azib.java.students.t050720;

import java.math.BigInteger;

/**
 * Factorial
 *
 * @author Marek
 */
public class Factorial {
	
	BigInteger retFact(int nr)
	{
		if(nr==0) return new BigInteger("1");
		else
		{
			BigInteger fv=new BigInteger("1");
			for(int i=1;i<=nr;i++)
			{
				//really nice syntax for a simple multiplication :)
				//but...at least there's no evil and confusing operator overloading
				fv=fv.multiply(BigInteger.valueOf(i));
			}
			return fv;
		}
	}

}
