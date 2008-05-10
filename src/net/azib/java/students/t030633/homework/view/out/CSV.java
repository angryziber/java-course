package net.azib.java.students.t030633.homework.view.out;

/**
 * Writes athletes to a comma-separated file using XSL transformation.
 * 
 * @author t030633
 */
public class CSV extends OutputTransformer {

	public CSV() {
		super(CSV.class.getResource("athletes.csv.xsl"));
	}

}
