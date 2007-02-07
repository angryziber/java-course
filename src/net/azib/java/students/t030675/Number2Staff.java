package net.azib.java.students.t030675;

/**
 * Number2Staff
 *
 * @author t030675
 */
public class Number2Staff {
	protected static int accessMe = 5;
	private int dontAccessMe;
	MegaClass m = new MegaClass();
	
	public static class MegaClass{
		int acessMe2 = accessMe;
	}
	
}
