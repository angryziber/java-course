package net.azib.java.students.t107110.homework;

import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;

import static net.azib.java.students.t107110.homework.Utils.getResultMock;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.mockito.Mockito.*;

/**
 * @author Eduard Shustrov
 */
public class XMLResultWriterTest {
	private static final String SCHEMA_FILE = "rated-results.xsd";
	private static final String RESULT_PATH = "/rated-results/result";
	private static final String EVENT_PATH = RESULT_PATH + "/event";

	private Result result;

	@Before
	public void prepare() throws DecathlonException, UnsupportedEncodingException {
		result = getResultMock();
	}

	@Test
	public void validateUsingXSD() throws SAXException, IOException, DecathlonException {
		final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		final Schema schema = factory.newSchema(getClass().getResource(SCHEMA_FILE));

		schema.newValidator().validate(new StreamSource(new StringReader(writeResult())));
	}

	@Test
	public void place() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("1", resultAttribute("place"), writeResult());
	}

	@Test
	public void points() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("11", resultAttribute("points"), writeResult());
	}

	@Test
	public void athlete() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("A", resultAttribute("athlete"), writeResult());
	}

	@Test
	public void birthday() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("0001-02-03", resultAttribute("birthday"), writeResult());
	}

	@Test
	public void country() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("CC", resultAttribute("country"), writeResult());
	}

	@Test
	public void sprint100m() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("0:01.00", timeEventResult("Sprint 100m"), writeResult());

		when(result.getSprint100m()).thenReturn(61.0);
		assertXpathEvaluatesTo("1:01.00", timeEventResult("Sprint 100m"), writeResult());
	}

	@Test
	public void longJump() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("2.01", distanceEventResult("Long Jump"), writeResult());
	}

	@Test
	public void shotPut() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("3.02", distanceEventResult("Shot Put"), writeResult());
	}

	@Test
	public void highJump() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("4.03", distanceEventResult("High Jump"), writeResult());
	}

	@Test
	public void sprint400m() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("0:05.04", timeEventResult("Sprint 400m"), writeResult());

		when(result.getSprint400m()).thenReturn(65.04);
		assertXpathEvaluatesTo("1:05.04", timeEventResult("Sprint 400m"), writeResult());
	}

	@Test
	public void hurdles110m() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("0:06.05", timeEventResult("Hurdles 110m"), writeResult());

		when(result.getHurdles110m()).thenReturn(66.05);
		assertXpathEvaluatesTo("1:06.05", timeEventResult("Hurdles 110m"), writeResult());
	}

	@Test
	public void discusThrow() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("7.06", distanceEventResult("Discus Throw"), writeResult());
	}

	@Test
	public void poleVault() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("8.07", distanceEventResult("Pole Vault"), writeResult());
	}

	@Test
	public void javelinThrow() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("9.08", distanceEventResult("Javelin Throw"), writeResult());
	}

	@Test
	public void race1500m() throws DecathlonException, IOException, SAXException, XpathException {
		assertXpathEvaluatesTo("0:10.09", timeEventResult("Race 1500m"), writeResult());

		when(result.getRace1500m()).thenReturn(70.09);
		assertXpathEvaluatesTo("1:10.09", timeEventResult("Race 1500m"), writeResult());
	}

	@Test(expected = DecathlonException.class)
	public void failOnWriteError() throws IOException, DecathlonException {
		final OutputStream stream = mock(OutputStream.class);
		doThrow(new IOException()).when(stream).close();

		final ResultWriter writer = new XMLResultWriter(stream);
		writer.write("", result);
		writer.close();
	}

	public String writeResult() throws DecathlonException, UnsupportedEncodingException {
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		final ResultWriter writer = new XMLResultWriter(stream);

		writer.write("1", result);
		writer.close();
		return stream.toString("UTF-8");
	}

	private static String resultAttribute(final String attributeName) {
		return RESULT_PATH + "/@" + attributeName;
	}

	private String timeEventResult(final String eventName)
			throws IOException, SAXException, XpathException, DecathlonException {
		return eventResult(eventName, "time");
	}

	private String distanceEventResult(final String eventName)
			throws IOException, SAXException, XpathException, DecathlonException {
		return eventResult(eventName, "distance");
	}

	private String eventResult(final String eventName, final String type)
			throws IOException, SAXException, XpathException, DecathlonException {
		assertXpathEvaluatesTo(type, eventAttribute(eventName, "type"), writeResult());
		return eventAttribute(eventName, "result");
	}

	private static String eventAttribute(final String eventName, final String attributeName) {
		return EVENT_PATH + "[@name='" + eventName + "']/@" + attributeName;
	}
}
