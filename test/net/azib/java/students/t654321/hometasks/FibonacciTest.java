package net.azib.java.students.t654321.hometasks;

import static org.junit.Assert.*;
import java.math.BigInteger;
import org.junit.Test;
import net.azib.java.students.t654321.hometasks.Fibonacci;

/**
 * FibonacciTest
 *
 * @author Karl
 */
public class FibonacciTest {

	// Verifies, that calculateFibonacciElement(16) returns 987;  
	@Test
	public void fibonacciSeriesElement16(){
		Fibonacci f = new Fibonacci();
		assertEquals("Calculating Fibonacci series element f(16) failed!", new BigInteger("987"), f.calculateFibonacciElement(16));
	}
	// Verifies, that calculateFibonacciElement(0) returns 0;
	@Test
	public void fibonacciSeriesElement0(){
		Fibonacci f = new Fibonacci();
		assertEquals("Calculating Fibonacci series element f(0) failed!", new BigInteger("0"), f.calculateFibonacciElement(0));
	}
	
	// Verifies, that calculateFibonacciElement(0) returns 1;
	@Test
	public void fibonacciSeriesElement1(){
		Fibonacci f = new Fibonacci();
		assertEquals("Calculating Fibonacci series element f(1) failed!", new BigInteger("1"), f.calculateFibonacciElement(1));
	}
	
	// Verifies, that calculateFibonacciElement(0) returns 84885164052257330097714121751630835360966663883732297726369399;
	@Test
	public void fibonacciSeriesElement298(){
		Fibonacci f = new Fibonacci();
		assertEquals("Calculating Fibonacci series element f(298) failed!", new BigInteger("84885164052257330097714121751630835360966663883732297726369399"), f.calculateFibonacciElement(298));
	}
}
