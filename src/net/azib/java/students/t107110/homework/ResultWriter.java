package net.azib.java.students.t107110.homework;

import java.io.IOException;

/**
 * @author Eduard Shustrov
 */
public interface ResultWriter {
	public void write(String place, Result result) throws IOException;

	public void close();
}
