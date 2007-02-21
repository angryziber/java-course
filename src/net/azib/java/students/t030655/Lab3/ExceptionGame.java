package net.azib.java.students.t030655.Lab3;

/**
 * ExceptionGame
 *
 * @author t030655
 */
public class ExceptionGame {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		byte[] b = new byte[] {0};
		processByteArray(b);
	}

	/**
	 * @param b
	 */
	private static void processByteArray(byte[] b) {
		try{
			System.out.println(b[0] + b[1]);
			//throw new IllegalStateException("method end");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null");
		}
		catch (Exception e) {
			 throw new RuntimeException ("Unexpected error", e);
		}
		finally{
			System.out.println("End");
		}
	}

}
