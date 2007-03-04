package net.azib.java.students.t020632;

/**
 * ExceptionGame
 *
 * @author t020632
 */
public class ExceptionGame {
	public static void main(String [] args){
		// byte [] b = new byte [] {0};
		processByteArray(null);
	}
	
	private static void processByteArray(byte [] b){
		try{
			System.out.println(b[0] + b[1]);
			// throw new IllegalStateException("method end");
			System.out.println("End");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No element with index " + e.getMessage());
			// throw new Exception(e);
		}
		catch(NullPointerException e){
			System.out.println("Passed array was null: " + e.getMessage());
		}
		catch(Exception e){
			throw new RuntimeException("Unexpected error", e);
		}
		finally{
			System.out.println("End");
		}
	}
	
}
