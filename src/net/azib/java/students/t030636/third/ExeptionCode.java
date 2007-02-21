package net.azib.java.students.t030636.third;

/**
 * ExeptionCode
 *
 * @author t030636
 */
public class ExeptionCode {
	public static void main(String[] args) {
		byte[] b = new byte[] {0};
		try {
			processByteArray(b);
		}
		catch (Exception e) {
			System.out.println(e.getCause());
		}
	}

	private static void processByteArray(byte[] b)  {
		try{
			System.out.println(b[0] + b[1]);
			throw new IllegalStateException("method end");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null");
		}
		catch (Exception e) {
			System.out.println("Unexpected error: " + e);
			//e.printStackTrace();
			throw new RuntimeException("unexpected error: ", e);
		}
		finally {
			System.out.println("End");
		}
	}
}
