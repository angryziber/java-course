package net.azib.java.students.t107110.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.text.*;
import java.util.Date;
import java.util.Locale;

import static net.azib.java.students.t107110.homework.DecathlonException.decathlonException;

/**
 * @author Eduard Shustrov
 */
public class XMLResultWriter implements ResultWriter {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final NumberFormat NUMBER_FORMAT =
			new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ROOT));
	private static final NumberFormat SECONDS_FORMAT =
			new DecimalFormat("00.00", DecimalFormatSymbols.getInstance(Locale.ROOT));

	private static final String XMLNS_XSI_ATTRIBUTE = XMLConstants.XMLNS_ATTRIBUTE + ":xsi";
	private static final String XSI_NO_NAMESPACE_SCHEMA_LOCATION_ATTRIBUTE = "xsi:noNamespaceSchemaLocation";
	private static final String RATED_RESULTS_XSD = "rated-results.xsd";

	private static enum ElementTag {
		RATED_RESULTS, RESULT, EVENT;

		@Override
		public String toString() {
			return toNameToken(super.toString());
		}
	}

	private static enum AttributeTag {
		PLACE, POINTS, ATHLETE, BIRTHDAY, COUNTRY, TYPE, NAME, RESULT;

		@Override
		public String toString() {
			return toNameToken(super.toString());
		}
	}

	private static enum EventTag {
		SPRINT_100M(Type.TIME), LONG_JUMP(Type.DISTANCE), SHOT_PUT(Type.DISTANCE), HIGH_JUMP(Type.DISTANCE),
		SPRINT_400M(Type.TIME), HURDLES_110M(Type.TIME), DISCUS_THROW(Type.DISTANCE), POLE_VAULT(Type.DISTANCE),
		JAVELIN_THROW(Type.DISTANCE), RACE_1500M(Type.TIME);

		private static enum Type {
			TIME, DISTANCE;

			@Override
			public String toString() {
				return toNameToken(super.toString());
			}
		}

		private final Type type;

		private EventTag(final Type type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return toTitleText(super.toString());
		}
	}

	private final OutputStream stream;
	private final InputStream template;
	private final Document document;
	private final Element rootElement;

	public XMLResultWriter(final OutputStream stream) throws DecathlonException {
		this(stream, null);
	}

	public XMLResultWriter(final OutputStream stream, final InputStream template) throws DecathlonException {
		this.stream = stream;
		this.template = template;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			rootElement = addElement(document, ElementTag.RATED_RESULTS);
			rootElement.setAttribute(XMLNS_XSI_ATTRIBUTE, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
			rootElement.setAttribute(XSI_NO_NAMESPACE_SCHEMA_LOCATION_ATTRIBUTE, RATED_RESULTS_XSD);
		} catch (ParserConfigurationException e) {
			throw decathlonException(e, Message.CANNOT_INIT_WRITING);
		}
	}

	@Override
	public void write(final String place, final Result result) {
		final Element resultElement = addResultElement(place, result);
		addEventElement(resultElement, EventTag.SPRINT_100M, result.getSprint100m());
		addEventElement(resultElement, EventTag.LONG_JUMP, result.getLongJump());
		addEventElement(resultElement, EventTag.SHOT_PUT, result.getShotPut());
		addEventElement(resultElement, EventTag.HIGH_JUMP, result.getHighJump());
		addEventElement(resultElement, EventTag.SPRINT_400M, result.getSprint400m());
		addEventElement(resultElement, EventTag.HURDLES_110M, result.getHurdles110m());
		addEventElement(resultElement, EventTag.DISCUS_THROW, result.getDiscusThrow());
		addEventElement(resultElement, EventTag.POLE_VAULT, result.getPoleVault());
		addEventElement(resultElement, EventTag.JAVELIN_THROW, result.getJavelinThrow());
		addEventElement(resultElement, EventTag.RACE_1500M, result.getRace1500m());
	}

	@Override
	public void close() throws DecathlonException {
		try {
			final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
			try {
				final TransformerFactory factory = TransformerFactory.newInstance();
				final Transformer transformer;
				if (template == null) transformer = factory.newTransformer();
				else transformer = factory.newTransformer(new StreamSource(template));

				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				transformer.transform(new DOMSource(document), new StreamResult(writer));
			} finally {
				writer.close();
				if (template != null) template.close();
			}
		} catch (TransformerException e) {
			throw decathlonException(e, Message.CANNOT_INIT_WRITING);
		} catch (IOException e) {
			throw decathlonException(e, Message.CANNOT_WRITE);
		}
	}

	private Element addResultElement(final String place, final Result result) {
		final Element resultElement = addElement(rootElement, ElementTag.RESULT);
		setTextAttribute(resultElement, AttributeTag.PLACE, place);
		setNumberAttribute(resultElement, AttributeTag.POINTS, result.getPoints());
		setTextAttribute(resultElement, AttributeTag.ATHLETE, result.getAthleteName());
		setDateAttribute(resultElement, AttributeTag.BIRTHDAY, result.getBirthday());
		setTextAttribute(resultElement, AttributeTag.COUNTRY, result.getCountry());
		return resultElement;
	}

	private void addEventElement(final Element resultElement, final EventTag eventTag, final double result) {
		final Element timeEventElement = addElement(resultElement, ElementTag.EVENT);
		setTextAttribute(timeEventElement, AttributeTag.NAME, eventTag.toString());
		setTextAttribute(timeEventElement, AttributeTag.TYPE, eventTag.type.toString());
		switch (eventTag.type) {
			case DISTANCE:
				setNumberAttribute(timeEventElement, AttributeTag.RESULT, result);
				break;
			case TIME:
				setTimeAttribute(timeEventElement, AttributeTag.RESULT, result);
				break;
		}
	}

	private Element addElement(final Node parent, final ElementTag elementTag) {
		final Element element = document.createElement(elementTag.toString());
		parent.appendChild(element);
		return element;
	}

	private static void setTextAttribute(final Element element, final AttributeTag attributeTag, final String text) {
		element.setAttribute(attributeTag.toString(), text);
	}

	private static void setNumberAttribute(final Element element, final AttributeTag attributeTag, final int number) {
		element.setAttribute(attributeTag.toString(), Integer.toString(number));
	}

	private static void setNumberAttribute(final Element element,
	                                       final AttributeTag attributeTag, final double number) {
		element.setAttribute(attributeTag.toString(), NUMBER_FORMAT.format(number));
	}

	private static void setTimeAttribute(final Element element, final AttributeTag attributeTag, final double time) {
		final int minutes = (int) Math.floor(time) / 60;
		final double seconds = time - minutes * 60;
		element.setAttribute(attributeTag.toString(), Integer.toString(minutes) + ":" + SECONDS_FORMAT.format(seconds));
	}

	private static void setDateAttribute(final Element element, final AttributeTag attributeTag, final Date date) {
		element.setAttribute(attributeTag.toString(), DATE_FORMAT.format(date));
	}

	private static String toNameToken(final String tag) {
		return tag.toLowerCase().replace("_", "-");
	}

	private static String toTitleText(final String tag) {
		return capitalizeWords(tag.replace("_", " "));
	}

	private static String capitalizeWords(final String text) {
		final StringBuilder builder = new StringBuilder(text);
		boolean space = true;
		for (int i = 0; i < builder.length(); i++) {
			final char character = builder.charAt(i);
			if (!Character.isWhitespace(character)) {
				if (space) builder.setCharAt(i, Character.toUpperCase(character));
				else builder.setCharAt(i, Character.toLowerCase(character));
				space = false;
			} else space = true;
		}
		return builder.toString();
	}
}
