package net.azib.java.simple;

/**
 * ExceptionGame
 *
 * @author anton
 */
public class ExceptionGame {

	public static void main(String[] args) {
		byte[] b = new byte[] {0};
		processByteArray(b);
	}

	private static void processByteArray(byte[] b) {
		try {
			System.out.println(b[0] + b[1]);
			//throw new IllegalStateException("method end");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index: " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null");
		}
		catch (Exception e) {
			handleUnknownException(e);
		}
		finally {
			System.out.println("End");			
		}
	}

	private static void handleUnknownException(Exception e) {
		throw new RuntimeException("Unexpected error", e);
	}

}
