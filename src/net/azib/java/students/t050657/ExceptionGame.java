package net.azib.java.students.t050657;

/**
 * ExceptionGame
 *
 * @author t050657
 */
public class ExceptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[2];
		try {
			processByteArray(b);
		}
		catch(Exception e) {
			System.out.println(e.getCause());
		}
	}

/**
 * 
 * @param b
 * @throws NullPointerException
 */
	private static void processByteArray(byte[] b) {
		try {
			System.out.println("b[12] = " + b[12]);
			//throw new IllegalStateException("method end");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception: no element with index " + e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println("Passed array was null");
		}
		catch(Exception e) {
			throw new RuntimeException("Unexpected error", e);
			//e.printStackTrace();
		}
		finally{
			System.out.println("End!");
		}
	}

}
