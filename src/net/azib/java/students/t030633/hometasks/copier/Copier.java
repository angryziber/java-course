package net.azib.java.students.t030633.hometasks.copier;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Copier
 * 
 * @author t030633
 */
public class Copier {

	private final PrintStream out;
	private CopyMethod method;
	private FileCopier copier;

	public Copier() {
		this(System.out);
	}

	public Copier(PrintStream printStream) {
		this.out = printStream;
		this.method = CopyMethod.S; // default method
	}

	/**
	 * @param src
	 * @param dest
	 * @param method
	 */
	public void main(File src, String dest, String... copyMethod) {

		File destfile = new File(dest);

		try {
			if (copyMethod.length > 0)
				this.method = CopyMethod.valueOf(copyMethod[0].toUpperCase());
		}
		catch (IllegalArgumentException e) {
			out.print("\'" + copyMethod[0] + "\' is not a valid method.");
			return;
		}

		if (!src.exists()) {
			out.print("File not found.");
			return;
		}
		else if (destfile.exists() && destfile.length() != 0) {
			out.print("Destination exists.");
			return;
		}
		else
			out.print("Using " + method.getName().toLowerCase() + " method to copy files.");

		copier = method.getCopier();

		try {
			copier.copy(src, destfile);
		}
		catch (IOException e) {
			System.err.println("Copy error.");
		}

	}

}
