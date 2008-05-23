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
	protected void initializeOutput(String[] fileName) throws IOException {
		if (this.output == null)
			// Initialize XSL transformation output to System.out
			this.output = System.out;
	}

}
