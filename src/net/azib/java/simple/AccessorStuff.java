package net.azib.java.simple;

/**
 * Number2Stuff
 *
 * @author anton
 */
public class AccessorStuff {
	protected int accessMe = 5;
	private static int dontAccessMe;
	MegaClass m = new MegaClass();
	
	public static class MegaClass {
		int accessMe2 = dontAccessMe;
	}
}
