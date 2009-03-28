package net.azib.java.students.t050545.hometasks.io;

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
