package net.azib.java.students.t011861;

/**
 * ExeptionGame
 *
 * @author t011861
 */
public class ExeptionGame {
	public static void main(String[] args){
		byte[] b = new byte[] {0, 1};
		prcessByteArray(b);
	}

	/**
	 * @param b
	 */
	private static void prcessByteArray(byte[] b) {
		try{
		System.out.println(b[0]+b[1]);
		throw new IllegalStateException("method end");
		
			}
		catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("no element with index" + e.getMessage());
		
		}
		catch (NullPointerException e) {
			System.out.println("Passed array was null : ");
		}
		catch (Exception e) {
			System.out.println("Unexpected error:" + e);
			e.printStackTrace();
		}
		finally {
			System.out.println("end");
		}
	}	

}
