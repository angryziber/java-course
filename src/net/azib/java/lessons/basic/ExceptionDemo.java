package net.azib.java.lessons.basic;

public class ExceptionDemo {
	public static class FooException extends Exception {
		public FooException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static void main(String[] args) throws FooException {
		try {
			byte[] b = {};
			b[0] = 1;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new FooException("Not enough space", e);
		}
		catch (Exception e) {
			System.err.println("We have a bug in the program, please submit a bug report!");
			e.printStackTrace();
		}
		finally {
			System.out.println("Bye-bye!");
		}
	}
}
