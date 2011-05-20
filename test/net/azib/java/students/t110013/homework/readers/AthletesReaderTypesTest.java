package net.azib.java.students.t110013.homework.readers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class AthletesReaderTypesTest {

	@Test
	public void consoleReaderTypeShouldInstantiateConsoleAthletesReader() {
		assertThat(AthletesReaderTypes.CONSOLE.newInstance("ignore"), is(ConsoleAthletesReader.class));
	}

	@Test
	public void csvReaderTypeShouldInstantiateCSVAthletesReader() {
		assertThat(AthletesReaderTypes.CSV.newInstance("ignore"), is(CSVAthletesReader.class));
	}

	@Test
	public void dbReaderTypeShouldInstantiateDBAthletesReader() {
		assertThat(AthletesReaderTypes.DB.newInstance("ignore"), is(DBAthletesReader.class));
	}
}
