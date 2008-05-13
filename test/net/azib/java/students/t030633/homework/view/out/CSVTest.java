package net.azib.java.students.t030633.homework.view.out;


/**
 * CSVTest
 *
 * @author t030633
 */
public class CSVTest extends AbstractFileOutputTransformerTest {

	public CSVTest() {
		super(new CSV(), CSV.class.getResource("athletes.csv.xsl"));
	}
	
}
