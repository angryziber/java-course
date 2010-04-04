package net.azib.java.lessons.io;

import java.io.File;
import java.io.IOException;

/**
 * FileCopier
 *
 * @author anton
 */
public interface FileCopier {

	/**
	 * Copies source file to destination.
	 * @param src
	 * @param dest
	 * @throws IOException if copying fails
	 */
	void copy(File src, File dest) throws IOException;

}
