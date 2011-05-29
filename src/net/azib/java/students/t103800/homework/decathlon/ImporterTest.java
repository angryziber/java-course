package net.azib.java.students.t103800.homework.decathlon;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.text.ParseException;

import static junit.framework.Assert.assertEquals;

public class ImporterTest {

	private String consoleTestInput =
	"\"Ufo Laev Väljus\"\n28.02.1992\nEE\n01.00\n1.00\n1.00\n1.00\n01.00\n01.00\n1.00\n1.00\n1.00\n01.00\nyes\n" +
	"\"ЖЙЙЮ\"\n11.11.2011\nIN\n1:14.41\n74.41\n74.41\n74.41\n1:14.41\n1:14.41\n74.41\n74.41\n74.41\n1:14.41\nyes\n" +
	"\"Lamba Ajus\"\n01.01.2000\nSO\n11:06.00\n666.00\n666.00\n666.00\n11:06.00\n11:06.00\n666.00\n666.00\n666.00\n" +
	"11:06.00\nno\n";

	private String csvTestInput =
	"\"Ufo Laev Väljus\",28.02.1992,EE,01.00,1.00,1.00,1.00,01.00,01.00,1.00,1.00,1.00,01.00\n" +
	"\"ЖЙЙЮ\",11.11.2011,IN,1:14.41,74.41,74.41,74.41,1:14.41,1:14.41,74.41,74.41,74.41,1:14.41\n" +
	"\"Lamba Ajus\",01.01.2000,SO,11:06.00,666.00,666.00,666.00,11:06.00,11:06.00,666.00,666.00,666.00,11:06.00";

	private Athlete[] results;

	@Before
	public void setup() throws ParseException, CountryCodeException {
		results = new Athlete[3];
		results[0] = new Athlete();
		results[0].setName("Ufo Laev Väljus");
		results[0].setBirthDate("28.02.1992");
		results[0].setCountryCode("ee");
		for(Athlete.Event event : Athlete.Event.values()) results[0].setResult(event, 1.0);

		results[1] = new Athlete();
		results[1].setName("ЖЙЙЮ");
		results[1].setBirthDate("2011-11-11");
		results[1].setCountryCode("in");
		for(Athlete.Event event : Athlete.Event.values()) results[1].setResult(event, 74.4055);

		results[2] = new Athlete();
		results[2].setName("Lamba Ajus");
		results[2].setBirthDate("1.1.2000");
		results[2].setCountryCode("SO");
		for(Athlete.Event event : Athlete.Event.values()) results[2].setResult(event, 666);
	}

	@Test
	public void testGetDataFromConsole() {
		Athlete[] importedResults = Importer.getImporter().getDataFromConsole(
				new ByteArrayInputStream(consoleTestInput.getBytes()));
		assertEquals(results[0].getAsCSVString(), importedResults[0].getAsCSVString());
		assertEquals(results[1].getAsCSVString(), importedResults[1].getAsCSVString());
		assertEquals(results[2].getAsCSVString(), importedResults[2].getAsCSVString());
	}

	@Test
	public void testGetDataFromCSVFile() throws ImporterException {
		Athlete[] importedResults = Importer.getImporter().getDataFromCSVFile(
				new ByteArrayInputStream(csvTestInput.getBytes()));
		assertEquals(results[0].getAsCSVString(), importedResults[0].getAsCSVString());
		assertEquals(results[1].getAsCSVString(), importedResults[1].getAsCSVString());
		assertEquals(results[2].getAsCSVString(), importedResults[2].getAsCSVString());
	}

}