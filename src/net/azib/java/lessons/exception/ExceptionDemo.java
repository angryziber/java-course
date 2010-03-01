package net.azib.java.lessons.exception;

/**
 * ExceptionDemo
 *
 * @author anton
 */
public class ExceptionDemo {
	@SuppressWarnings("null") // intended
	public static void main(String[] args) {
		int i = 1;
		String s = null;
		try {
			Thread.sleep(100);
			s.toString();
			i = i / 0;
		}
		catch (ArithmeticException e) {
			System.out.println("Division failed");
		}
		catch (NullPointerException e) {
			System.out.println("Oops, we have a bug..");
		}
		catch (RuntimeException e) {
			System.out.println("I give up... Please report the problem below:");
			e.printStackTrace();
		}
		catch (OutOfMemoryError e) {
			System.out.println("Sorry, you need to have more memory...");
		}
		catch (InterruptedException e) {
			System.out.println("User requested cancel");
		}
		finally {
			System.out.println(i);
		}			
	}
}
