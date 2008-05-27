package net.azib.java.students.t020281;

import java.util.Date;

/**
 * HelloWorld
 *
 * @author t020281
 */
public class HelloWorld 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		System.out.println(Constants.GREETING_MESSAGE);
		System.out.println(Math.pow(2, 3));
		System.out.println(HelloWorld.class.getResource("test.csv"));
		
	}
}
