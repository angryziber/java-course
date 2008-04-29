package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.view.Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Writes athletes to a comma-separated file using XSL transformation.
 * 
 * @author t030633
 */
public class CSV extends OutputTransformer {

	public CSV() throws FileNotFoundException {
		super(CSV.class.getResource("athletes.csv.xsl"), new FileOutputStream(new Files().getOutputFile("csv")));

	}

}
