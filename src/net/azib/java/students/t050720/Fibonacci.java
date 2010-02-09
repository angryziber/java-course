package net.azib.java.students.t050720;

import java.math.BigInteger;


/**
 * Fibonacci
 *
 * @author Marek
 */
public class Fibonacci {
	//Store the already calculated fibonacci sequence and the "rank" of the sequence
	//so that when we request a lower-than-rank value, it is returned instantly
	//without any recalculation
	private int m_rank;
	private static BigInteger[] m_numbahs;
	
	Fibonacci()
	{
		//The first two values of the fibonacci sequence are predefined
		Fibonacci.m_numbahs = new BigInteger[2];
		Fibonacci.m_numbahs[0]=new BigInteger("0");
		Fibonacci.m_numbahs[1]=new BigInteger("1");
		m_rank=2;
	}
	
	private BigInteger calcFib(int f)
	{
		m_rank=f;
		
		//We need to grow the static array. Because, in all its "greatness", java
		//still lacks a nice way to grow a friggin' array, we need such hocuspocus.
		BigInteger[] tmpA=new BigInteger[f+1];
		System.arraycopy(Fibonacci.m_numbahs, 0, tmpA, 0, Fibonacci.m_numbahs.length);
		Fibonacci.m_numbahs=tmpA;
		
		//Now calculate the actual fibonacci values and add them to the array
		for(int i=2;i<=f;i++)
		{
			BigInteger av=Fibonacci.m_numbahs[i-1].add(Fibonacci.m_numbahs[i-2]);
			Fibonacci.m_numbahs[i]=av;
		}
		return Fibonacci.m_numbahs[m_rank];
	}
	
	public BigInteger getNumber(int input) throws Exception
	{
		if (input<1) throw new Exception("Fibonacci::getNumber input must be 1 or greater");
		
		BigInteger rv;
		//If we have already computed the fibonacci values, let's not waste time
		//recalculating...
		if( input >= m_rank)
		{
			rv=calcFib(input);
		}
		//...and return the requested value instantly
		else rv=Fibonacci.m_numbahs[input-1];
		return rv;
	}

}
