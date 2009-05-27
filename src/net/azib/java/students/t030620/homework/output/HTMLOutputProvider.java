package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;

import java.io.File;
import java.util.Collection;
import java.util.Properties;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Node;

/**
 * HTMLOutputProvider
 *
 * @author Maksim Konstantinov 030620
 */
public class HTMLOutputProvider implements OutputProvider {
	
	private String xslPath;
	
	HTMLOutputProvider(Properties props) throws Exception {
		if(props == null) {
			throw new Exception("No properties file found for input HTML component");
		}
		xslPath	= props.getProperty("xsl-file");
		
		if(xslPath == null) {
			throw new Exception("No xsl file name found in output HTML component configuration file");
		}
	}
	
	/**
	 * Outputs the collection of Decathlon score to the specified file in HTML format
	 * 
	 * @param scores sorted collection of DecathleteScoreKeeper 
	 * @param param File instance for the HTML content to be written
	 */
	@Override
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception {
		
		XMLOutputProvider provider = new XMLOutputProvider();
		Node node = provider.getXML(scores);	
		File outputFile = (File)param;
		outputFile.createNewFile();
		writeFile(outputFile, node);
	}
	
	private void writeFile(File outputFile, Node root) throws TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(HTMLOutputProvider.class.getResourceAsStream(xslPath)));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(root), new StreamResult(outputFile));
	}

}
