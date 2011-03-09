package net.azib.java.students.t104922.basics;

public class exceptionDemo {

    public static class FooException extends Exception {
        public FooException(String messagage, Exception e) {

        }
    }

    public static void main(String[] args) throws FooException {
        try {
            byte[] b0 = {};
            byte[] b1 = {};
            b0[0] = 1;
            b1[1] = 0;
            //throw new FooException();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Sout says: overloading, not enough space");
            throw new FooException("throw says: Not enough space", e);

        } catch (Exception e) {
            e.getMessage();
            e.getCause();
            e.getStackTrace();
            System.err.println("Bugger in program");
            e.printStackTrace();
        } finally {
            System.err.println("Bye");
        }
    }
}
