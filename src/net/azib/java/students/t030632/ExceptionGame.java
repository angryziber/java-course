package net.azib.java.students.t030632;

/**
 * ExceptionGame
 *
 * @author Toni
 */
public class ExceptionGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] b = new byte[]{0};
		
			processByteArray(b);
		

	}

	/**
	 * @param b
	 */
	private static void processByteArray(byte[] b){
		try{
			System.out.println(b[1]);
			//throw new IllegalStateException("method end");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No elements with index: " + e.getMessage());
			
		}
		catch (NullPointerException e) {
			System.out.println("Given array does not exist: " + e.getMessage());
		}
		catch (Exception e) {
			throw new RuntimeException("Unexpected Error: " + e);
		}
		finally{
			System.out.println("End");
		}
		
	}

}
