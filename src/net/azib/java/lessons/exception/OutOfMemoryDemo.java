package net.azib.java.lessons.exception;

/**
 * OutOfMemoryDemo
 *
 * @author anton
 */
public class OutOfMemoryDemo {
	public static void main(String[] args) throws Exception {
		try {
			Object[] objects = new Object[100000];
			for (int i = 0; i < objects.length; i++) {
				objects[i] = new byte[10000];
				Thread.sleep(10);
			}
			System.out.println(objects[0]);
		}
		catch (OutOfMemoryError e) {
			System.err.println(e.toString());
		}
	}
}
