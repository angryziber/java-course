/*
 * Created on 08.06.2007
 * @author Konstantin Tarletski
 */
package net.azib.java.students.t981774.homework;

import java.io.File;
import java.util.Vector;

/**
 * @author Konstantin Tarletski
 * @version 1.0
 * @date 08.06.2007
 */
public class FileReader implements IReader {

	private File inputFile;
	
	/* (non-Javadoc)
	 * @see net.azib.java.students.t981774.homework.IReader#executeReader()
	 */
	public Vector executeReader() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @author Konstantin Tarletski
	 * @version 1.0
	 * @date 08.06.2007
	 * @return Returns the inputFile.
	 */
	public File getInputFile() {
		return inputFile;
	}
	/** 
	 * @author Konstantin Tarletski
	 * @version 1.0
	 * @date 08.06.2007
	 * @param inputFile The inputFile to set.
	 */
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}
}
