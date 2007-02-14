package net.azib.java.students.t960644;

/**
 * Number2Test
 *
 * @author t960644
 */
public class Number2Test {
	protected static int accessible = 5;
//	private int dontAccessMe;
	MClass m = new MClass();
	public class MClass {
		int accessMe2 = accessible;
	}
}
