package net.azib.java.students.t107110.homework;

/**
 * @author Eduard Shustrov
 */
public interface ResultReader {
	public Result read() throws DecathlonException;

	public void close();
}
