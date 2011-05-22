package net.azib.java.students.t107110.homework;

/**
 * @author Eduard Shustrov
 */
public interface ResultWriter {
	public void write(String place, Result result) throws DecathlonException;

	public void close() throws DecathlonException;
}
