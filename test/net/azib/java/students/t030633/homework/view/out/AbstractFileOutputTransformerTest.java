package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import org.junit.Test;


/**
 * AbstractFileOutputTransformerTest
 *
 * @author t030633
 */
public abstract class AbstractFileOutputTransformerTest  extends AbstractOutputTransformerTest {

	AbstractFileOutputTransformerTest(OutputTransformer outputTransformer, URL stylesheet) {
		super(outputTransformer, stylesheet);
	}

	@Test
	public void outputFileNotFoundExceptionIsThrown() {
		try {
			// Parameters have not been set, write should throw an exception
			outputTransformer.write(new LinkedList<Athlete>());
		}
		catch (IOException e) {
			assertEquals("Output file not specified.", e.getMessage());
		}
	}
	
}
