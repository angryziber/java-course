package net.azib.java.students.t093759.homework;

import org.junit.Test;

/**
 * @author dionis
 *         6/2/111:45 AM
 */
public class CSVLoaderTest {
		@Test(expected = IllegalArgumentException.class)
	public void exactlyOneAdditionalParamShouldBeProvided() {
		new CSVLoader().load();
	}

	@Test(expected = IllegalArgumentException.class)
	public void additionalParamShouldBeString() {
		new CSVLoader().load(12);
	}
}
