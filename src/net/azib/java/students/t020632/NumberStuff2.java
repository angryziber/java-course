package net.azib.java.students.t020632;

/**
 * NumberStuff2
 *
 * @author t020632
 */
public class NumberStuff2 {
	protected static int accessMe;
	private int dontAccess;
	
	public class MegaClass{
		int accessMe2 = accessMe;
	}
}
