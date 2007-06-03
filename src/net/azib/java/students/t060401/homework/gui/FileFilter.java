package net.azib.java.students.t060401.homework.gui;

import java.io.File;

/**
 * Class to filter files for .csv only
 */
public class FileFilter extends javax.swing.filechooser.FileFilter {
	/**
	 * @param f
	 *            File object passed by the system.
	 * @return Returns true if the File object should pass the filter.
	 */
	public boolean accept(File f) {
		// if it is a directory -- we want to show it so return true.
		if (f.isDirectory())
			return true;

		// get the extension of the file

		String extension = getExtension(f);
		// check to see if the extension is equal to "erg"
		if ((extension.equals("csv")))
			return true;
		return false;
	}

	/**
	 * Method to ask for filter description.
	 * 
	 * @return Returns the String containing the description of the filter.
	 */
	public String getDescription() {
		return "CSV files *.csv";
	}

	/**
	 * Method to get the extension of the file, in lowercase
	 */
	private String getExtension(File f) {
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 && i < s.length() - 1)
			return s.substring(i + 1).toLowerCase();
		return "";
	}
}