package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.custommonkey.xmlunit.Validator;
import org.junit.Test;

/**
 * XMLTest
 * 
 * @author t030633
 */
public class XMLTest {

	@Test
	public void outputIsValidXML() throws Exception {

		List<Athlete> list = new LinkedList<Athlete>();
		Athlete mockAthlete = createMockAthlete();
		list.add(mockAthlete);

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		new XML(output).write(list); // Generate XML

		Validator v = new Validator(output.toString());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(XMLTest.class.getResource("competition.xsd").getFile());

		assertTrue(v.isValid()); // Validate XML
		verify(mockAthlete); // All athlete methods should be called once

	}

	private Athlete createMockAthlete() {
		Athlete mockAthlete = createMock(Athlete.class);
		expect(mockAthlete.getName()).andReturn("testName");
		expect(mockAthlete.getCountry()).andReturn("testCountry");
		expect(mockAthlete.getBirthDate()).andReturn(new Date());
		Map<Event, Double> mockResults = new HashMap<Event, Double>();
		mockResults.put(Event.values()[1], 1D);
		expect(mockAthlete.getResults()).andReturn(mockResults);
		expect(mockAthlete.getScore()).andReturn(9000);
		replay(mockAthlete);
		return mockAthlete;
	}

}
