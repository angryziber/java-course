package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;

/**
 * AbstractOutputTransformerTest is for XSL transformation testing
 * 
 * @author t030633
 */
public abstract class AbstractOutputTransformerTest {

	private URL stylesheet;
	protected OutputTransformer outputTransformer;

	AbstractOutputTransformerTest(OutputTransformer output, URL stylesheet) {
		this.outputTransformer = output;
		this.stylesheet = stylesheet;
	}

	@Test
	public void canTransformWithGivenXSL() throws Exception {

		List<Athlete> list = new LinkedList<Athlete>();
		Athlete mockAthlete = createMockAthlete();
		list.add(mockAthlete);

		// Set up XML to test against
		ByteArrayOutputStream xml = new ByteArrayOutputStream();
		new XML(xml).write(list);

		// Do Output write test
		ByteArrayOutputStream testResult = new ByteArrayOutputStream();
		outputTransformer.setOutputStream(testResult);
		outputTransformer.write(list);
		
		// Expected transformation result		
		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(stylesheet.openStream()));
		OutputStream expectedResult = new ByteArrayOutputStream();
		transformer.transform(new StreamSource(new ByteArrayInputStream(xml.toByteArray())), new StreamResult(expectedResult));
		
		assertEquals(expectedResult.toString(), testResult.toString());

	}

	private Athlete createMockAthlete() {
		Athlete mockAthlete = createMock(Athlete.class);
		expect(mockAthlete.getName()).andReturn("testName").times(2);
		expect(mockAthlete.getCountry()).andReturn("testCountry").times(2);
		expect(mockAthlete.getBirthDate()).andReturn(new Date()).times(2);
		Map<Event, Double> mockResults = new HashMap<Event, Double>();
		mockResults.put(Event.values()[1], 1D);
		expect(mockAthlete.getResults()).andReturn(mockResults).times(2);
		expect(mockAthlete.getScore()).andReturn(9000).times(2);
		replay(mockAthlete);
		return mockAthlete;
	}

}
