package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.view.Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Outputs HTML by transforming XML to HTML
 * 
 * @author t030633
 */
public class HTML extends OutputTransformer {

	public HTML() throws FileNotFoundException {
		super(HTML.class.getResource("athletes.html.xsl"), new FileOutputStream(new Files().getOutputFile("html")));
	}

}
