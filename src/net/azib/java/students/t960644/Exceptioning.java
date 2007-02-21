package net.azib.java.students.t960644;

/**
 * Exceptioning
 *
 * @author t960644
 */
public class Exceptioning {

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
	 * @throws Exception 
	 */
	private static void processByteArray(byte[] b) {
		try {
			System.out.println(b[0]);
			throw new IllegalStateException("method end");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No element with index: " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("No array!?!?!??");
		}
		catch (Exception e) {
			//System.out.println("Unexpected error: " + e);
			//e.printStackTrace();
			handleUnexpectedException(e);
		}
		finally {
			System.out.println("End");			
		}
	}

	/**
	 * @param e
	 */
	private static void handleUnexpectedException(Exception e) {
		throw new RuntimeException("Totally unexpected.", e);
	}

}
