package net.azib.java.students.t030633.homework.view.out;

/**
 * HTMLTest
 *
 * @author t030633
 */
public class HTMLTest extends AbstractFileOutputTransformerTest {

	public HTMLTest() {
		super(new HTML(), HTML.class.getResource("athletes.html.xsl"));
	}
	
}
