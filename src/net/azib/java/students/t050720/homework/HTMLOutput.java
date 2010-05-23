package net.azib.java.students.t050720.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

/**
 * <b>HTMLOutput</b>
 * 
 * Handles exporting of data to basic HTML format.
 *
 * @author Marek
 */
public class HTMLOutput implements Output {

	private File f;
	
	/**
	 * @param filename is the output file name. Gets created or overwritten.
	 */
	public HTMLOutput(String filename) {
		f=new File(filename);
	}

	/**
	 * Writes the data from the passed ArrayList<Records> to the 
	 * previously specified file in HTML.
	 * The data is first written to a temporary XML file and then 
	 * converted to HTML using the decathlon.xsl file.
	 * 
	 * @throws Exception
	 */
	@Override
	public void flush(ArrayList<Record> records) throws Exception {
		File xmlF = File.createTempFile("decathlon", ".tmp");
		xmlF.deleteOnExit();
		
		XMLOutput xmlO=new XMLOutput(xmlF.getAbsolutePath());
		xmlO.flush(records);
		
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer (new javax.xml.transform.stream.StreamSource("src/net/azib/java/students/t050720/homework/decathlon.xsl"));
		transformer.transform(new javax.xml.transform.stream.StreamSource(xmlF.getAbsolutePath()), new javax.xml.transform.stream.StreamResult(new FileOutputStream(f)));
	}

}
