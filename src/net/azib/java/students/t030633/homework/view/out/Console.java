package net.azib.java.students.t030633.homework.view.out;

/**
 * Outputs athletes to console using XSL transformation.
 * 
 * @author t030633
 */
public class Console extends OutputTransformer {

	static final String LN = System.getProperty("line.separator");
	static final String BEGIN_MSG = LN + "-=[Athletes]=- " + LN;

	public Console() {
		super(Console.class.getResource("athletes.console.xsl"), System.out);
	}

}
