package net.azib.java.students.t093759.homework;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

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

	@Test
	public void inputExample() {
		String file = getClass().getResource("example.csv").getFile();
		assertThat(new CSVLoader().load(file).size(), equalTo(4));
	}
}
