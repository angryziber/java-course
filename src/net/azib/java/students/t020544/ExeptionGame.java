package net.azib.java.students.t020544;

/**
 * ExeptionGame
 * 
 * @author Julija Kondratjeva
 */
public class ExeptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[] { 0,9};
		processByteArray(b);
	}

	/**
	 * @param b
	 */
	// refactor -> extract method
	private static void processByteArray(byte[] b) {
		try {
			System.out.println(b[0] + b[1]);
			//throw new IllegalStateException("method end");
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("No element with index " + e.getMessage());
			//throw new Exception(e);
			// System.out.println("No element with index "
			// +e.printStackTrace());
		}

		catch (NullPointerException e) {
			System.out.println("Passed array was null.");
		}

		catch (Exception e) {
			//System.out.println("Unexpected error: " + e);
			throw new RuntimeException("Unexpected error: " , e);
		}

		finally {
			System.out.println("End.");
		}
	}
}
