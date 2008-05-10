package net.azib.java.students.t030633.homework.view.out;

/**
 * Writes athletes to HTML file using XSL transformation.
 * 
 * @author t030633
 */
public class HTML extends OutputTransformer {

	public HTML() {
		super(HTML.class.getResource("athletes.html.xsl"));
	}

}
