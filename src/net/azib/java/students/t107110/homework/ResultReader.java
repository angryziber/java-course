package net.azib.java.students.t107110.homework;

import java.io.IOException;

/**
 * @author Eduard Shustrov
 */
public interface ResultReader {
	public Result read() throws IOException, DecathlonException;

	public void close();
}
