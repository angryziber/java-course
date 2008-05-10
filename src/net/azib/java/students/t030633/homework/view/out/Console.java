package net.azib.java.students.t030633.homework.view.out;

import java.io.IOException;

/**
 * Outputs athletes to console using XSL transformation.
 * 
 * @author t030633
 */
public class Console extends OutputTransformer {

	public Console() {
		super(Console.class.getResource("athletes.console.xsl"));
	}

	@Override
	public void init() throws IOException {
		this.output = System.out;
	}

}
