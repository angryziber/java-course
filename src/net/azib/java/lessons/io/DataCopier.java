package net.azib.java.lessons.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * DataCopier - a more generic copier
 *
 * @author anton
 */
public interface DataCopier {

	/**
	 * Copies source data to destination.
	 * @param src provides the input stream
	 * @param dest provides the output stream
	 * @throws IOException if copying fails
	 */
	void copy(InputStream src, OutputStream dest) throws IOException;

}
