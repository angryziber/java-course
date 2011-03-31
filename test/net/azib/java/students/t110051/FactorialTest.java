package net.azib.java.students.t110051;

import net.azib.java.students.t110051.Lesson2.Factorial;
import org.hamcrest.Matcher;
import org.junit.Test;
import java.math.BigInteger;

import static java.lang.Integer.*;
import static net.azib.java.lessons.basic.FibonacciTest.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FactorialTest {

	@Test
	public void factorialOfOne(){
		assertEquals("factorial failed @ 1", factorial(1), BigInteger.valueOf(1));
	}
	@Test
	public void factorialOfZero(){
		assertEquals("factorial failed 0", factorial(1), BigInteger.valueOf(1));
	}

	@Test
	public void factorialOfTen(){
		assertEquals("factorial failed @ 10", factorial(10), BigInteger.valueOf(3628800));
	}

	public static BigInteger factorial (int n){
		return new Factorial().Computation(n);
	}


}
