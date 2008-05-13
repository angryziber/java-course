package net.azib.java.students.t030633.homework.view.out;


/**
 * ConsoleTest
 *
 * @author t030633
 */
public class ConsoleTest extends AbstractOutputTransformerTest {

	public ConsoleTest() {
		super(new Console(), Console.class.getResource("athletes.console.xsl"));
	}
	
}
