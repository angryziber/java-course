package net.azib.java.students.t092855.homework;



import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Decathlon HTML output. <br>
 *     For outputting decathlon data to HTML file.
 *
 * @author t092855
 */
public class OutputHTML implements OutputStrategy {

	/**
	 * Writes decathlon data to HTML file.
	 * @param competition data
	 * @param args output HTML file name or path
	 */
	@Override
	public void writeOutput(Competition competition, String... args) {

		if (competition.getCompetitors().isEmpty())
			return;

		InputStream inputStream;

		inputStream = getClass().getResourceAsStream("decathlon.xsl");
		Transformer transformer;
		try {
			transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(inputStream));
			DOMSource source = new DOMSource(new OutputXML().createDecathlonXML(competition));
			transformer.transform(source, new StreamResult(new FileOutputStream(new File(args[0]))));
		} catch (Exception e) {
			System.out.println(Error.ERROR_HTML_CREATION_FAILED.getErrorText());
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				System.out.println(Error.ERROR_XSL_CLOSING_FAILED.getErrorText());
			}
		}
	}
}
