package net.azib.java.students.t050209;

/**
 * ExceptionGame
 *
 * @author t050209
 */
public class ExceptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] b = new byte[] {0};
		try {
			processByteArray(b);
		}
		catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

	/**
	 * @param b
	 */
	private static void processByteArray(byte[] b) /*throws Exception */{
		try {
			System.out.println(b[1]);
			throw new IllegalStateException("method end");
			
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index " + e.getMessage());
			/*throw new Exception(e);*/
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null");
		}
		catch (Exception e) {
			throw new RuntimeException("Unexpected error: ", e);
			/*e.printStackTrace();*/
		}
		finally { /* pole kohustuslik */
			System.out.println("End");
		}
	}

}
