package net.azib.java.students.t030675;

/**
 * ExceptionGame
 *
 * @author t030675
 */
public class ExceptionGame {

	public static void main(String[] args) /*throws Exception*/ {
		byte[] b = new byte[] {5};
//		try {
			processByteArray(b);
//		}
//		catch (Exception e) {
//			System.out.println("Cause: " + e.getCause());
//		}
	}

	private static void processByteArray(byte[] b) {
		try{
			System.out.println(b[0] + b[1]);
			throw new IllegalStateException("method end");	
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index " + e.getMessage());
//			throw new Exception(e){
//				
//			};
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null: " + e.getMessage());
		}
		catch (Exception e) {
			handleException(e);
//			System.out.println("Unexpected error: " + e);
		}
		/*finally{
			System.out.println("End");
		}*/
	}

	/**
	 * @param e
	 */
	private static void handleException(Exception e) {
		throw new RuntimeException("Unexpected error",e);
	}
	
}
