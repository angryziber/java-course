package net.azib.java.students.t100224.homework.io;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLValidator {
	/**
	 * Validates an XML file using the declared DTD
	 *
	 * @param filename - an XML file that is has to be validated
	 * @return true - if file has a correct structure, otherwise - false
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public boolean validateXML(String filename) throws IOException, ParserConfigurationException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(
					new ErrorHandler() {
						@Override
						public void warning(SAXParseException exception) throws SAXException {
							System.out.println("WARNING : " + exception.getMessage());
						}

						@Override
						public void error(SAXParseException exception) throws SAXException {
							System.out.println("ERROR : " + exception.getMessage());
							throw exception;
						}

						@Override
						public void fatalError(SAXParseException exception) throws SAXException {
							System.out.println("FATAL : " + exception.getMessage());
							throw exception;
						}
					}
			);
			builder.parse(new InputSource(filename));
			return true;

		} catch (SAXException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
