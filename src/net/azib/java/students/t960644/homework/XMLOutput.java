package net.azib.java.students.t960644.homework;

import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

//import com.sun.org.apache.xml.internal.serialize.OutputFormat;
//import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * XMLOutput
 * 
 * @author Lembit
 */
public class XMLOutput {
	protected Document doc;

	public void writeData(Competition competition) {
		CreateDoc();
		CreateDocTree(competition);

	}
	
	protected Element writeLine(Result result) {
		Element resElement = doc.createElement("result");
		resElement.appendChild(writeElement("position",result.getPosition()));
		resElement.appendChild(writeElement("score",Integer.toString(result.calcResult())));
		resElement.appendChild(writeElement("athlete",result.getAthlete().getName()));
		resElement.appendChild(writeElement("born",result.getAthlete().getBirthDate()));
		resElement.appendChild(writeElement("country",result.getAthlete().getCountryCode()));
		resElement.appendChild(writeElement("race-100m",result.getStringRace100()));
		resElement.appendChild(writeElement("long-jump",result.getStringLongJump()));
		resElement.appendChild(writeElement("shot-put",result.getStringShotPut()));
		resElement.appendChild(writeElement("high-jump",result.getStringHighJump()));
		resElement.appendChild(writeElement("race-400m",result.getStringRace400()));
		resElement.appendChild(writeElement("hurdles-110m",result.getStringHurdles110()));
		resElement.appendChild(writeElement("discus-throw",result.getStringDiscusThrow()));
		resElement.appendChild(writeElement("pole-vault",result.getStringPoleVault()));
		resElement.appendChild(writeElement("javelin-throw",result.getStringJavelinThrow()));
		resElement.appendChild(writeElement("race-1500m",result.getStringRace1500()));		
		return resElement; 
	}
	
	protected Element writeElement(String tagName,String data){
		Element el = doc.createElement(tagName);
		el.appendChild(doc.createTextNode(data));
		return el;
	}

	public void CreateDoc() {
		try {
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			DOMImplementation domImplementation = docBuilder.getDOMImplementation();
			doc = domImplementation.createDocument(null, "decathlon", null);
			doc.insertBefore(doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\"decathlon.xsl\""),doc.getDocumentElement());
			
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void CreateDocTree(Competition competition) {
		Element rootElement = doc.getDocumentElement();
		Element compElement = doc.createElement("competition");
		rootElement.appendChild(compElement);
		if (competition.getDescription()!=null) {
			compElement.appendChild(writeElement("description",competition.getDescription()));
		}
		if (!competition.getStringDate().isEmpty()) {
			compElement.appendChild(writeElement("date",competition.getStringDate()));			
		}
		if (competition.getCountryCode()!=null){
			compElement.appendChild(writeElement("location",competition.getCountryCode()));
		}
		for (Result r:competition.getResults()) {
			compElement.appendChild(writeLine(r));
		}
	}
	public void printXML(OutputStream out) {
		 DOMSource domSource = new DOMSource(doc);
		 StreamResult streamResult = new StreamResult(out);
		 TransformerFactory tf = TransformerFactory.newInstance();
		 Transformer serializer;
		try {
			serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.INDENT,"yes");
			serializer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			serializer.transform(domSource, streamResult);
		}
		catch (Exception e) {
			// do nothing
			e.printStackTrace();
		}
	}

}
