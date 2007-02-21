package net.azib.java.students.t030656;

/**
 * ExceptionGame
 *
 * @author t030656
 */
public class ExceptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[] {0, 1};	
		try {
			processByteArray(b);
		}
		catch (Exception e) {
			System.out.println(e.getCause());
		}
	} // end main

	/**
	 * @param b
	 */
	private static void processByteArray(byte[] b){
		try{
			System.out.println("Inside try block string: " + (b[0] + b[2]));
			//throw new IllegalStateException("method end");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Index out of range. Index: " + e.getMessage());
		}
		catch(NullPointerException e){
			System.out.println("Passed array was NULL!");
		}
		catch(Exception e){
			System.out.println("Unexpected error: " + e);
			throw new RuntimeException("Unexpected error", e);
		}
		finally{
			System.out.println("The End!");
		}
	} // end processByteArray	
} // end class ExceptionGame
