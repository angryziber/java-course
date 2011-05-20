package net.azib.java.students.t110013.homework.writers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class AthletesWriterTypesTest {

	@Test
	public void consoleWriterTypeShouldInstantiateConsoleAthletesWriter() {
		assertThat(AthletesWriterTypes.CONSOLE.newInstance("ignore"), is(ConsoleAthletesWriter.class));
	}

	@Test
	public void csvWriterTypeShouldInstantiateCSVAthletesWriter() {
		assertThat(AthletesWriterTypes.CSV.newInstance("ignore"), is(CSVAthletesWriter.class));
	}

	@Test
	public void xmlWriterTypeShouldInstantiateDBAthletesWriter() {
		assertThat(AthletesWriterTypes.XML.newInstance("ignore"), is(XMLAthletesWriter.class));
	}

	@Test
	public void htmlWriterTypeShouldInstantiateHTMLAthletesWriter() {
		assertThat(AthletesWriterTypes.HTML.newInstance("ignore"), is(HTMLAthletesWriter.class));
	}
}
