package net.azib.java.students.t011861.homework;

import java.io.File;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;

/**
 * OutDataToHtml
 *
 * @author 011861
 * @param Input parameters are output filename, stylesheet filename and data from ProcessedData module! !
 * @return Result is generated HTML file in projects root directory
 */
public class OutDataToHtml {
public void showInHtmlFile(File output, File stylesheet, List<String[]> completeData) {
		
		CreateDocument newDoc = new CreateDocument();
		Document doc = newDoc.createDocument(completeData);
		//Load the transformer using JAXP
		TransformerFactory factory = TransformerFactory.newInstance();
		DocumentResult result = null;
		try {
			Transformer transformer = factory.newTransformer(new StreamSource(stylesheet));
			//Style the given document
			DocumentSource source = new DocumentSource(doc);
			result = new DocumentResult();
			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			System.out.println("Problem with configuring " + stylesheet+ " stylesheet file! " + e);
		} catch (TransformerException e) {
			System.out.println("Problem with transforming new html document! " + e);
		}
		//Return the transformed document
		Document transformedDoc = result.getDocument();
		WriteIntoFile writeFile = new WriteIntoFile();
		writeFile.writeIntoFile(output, transformedDoc);
	}
}
