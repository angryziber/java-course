package net.azib.java.students.t030721;

/**
 * ExeptionGame
 *
 * @author t030721
 */
public class ExeptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			byte[] b = new byte[] {0, 1};
			processByteArray(b);
	}


	private static void processByteArray(byte[] b) {
		try{
		System.out.println((b[0] + b[1])/b[0]);
		//throw new IllegalStateException("method end");
		System.out.println("End");
	}
	catch (ArrayIndexOutOfBoundsException e){
		System.out.println("No element with index " + e.getMessage());
	}
	catch (NullPointerException e) {
		System.out.println("Passed array was null");
	}
	catch (Exception e){
		System.out.println("Unexpected error: " + e);
		throw new RuntimeException ("Unexpected errror", e);
	}
	finally {
		System.out.println("End 2");
	}
	}
}

