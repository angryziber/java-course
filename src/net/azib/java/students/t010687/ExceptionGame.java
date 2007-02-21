package net.azib.java.students.t010687;

/**
 * ExceptionGame
 *
 * @author t010687
 */
public class ExceptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[] {0};
		processByteArray(b);
	}

	/**
	 * @param b
	 */
	private static void processByteArray(byte[] b) {
		try {
		System.out.println(b[1]);
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println("No element with index " + e.getMessage() );
		}
		catch (NullPointerException e){
			System.out.println("Passed arrays was null");
		}
		catch (Exception e){
			throw new RuntimeException("Unexpected exception ", e);
		}
		finally {
			System.out.println("End");
		}
	}

}
