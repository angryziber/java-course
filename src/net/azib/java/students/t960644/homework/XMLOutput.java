package net.azib.java.students.t960644.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;

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
		resElement.appendChild(writeElement("race-100m",DecathlonEvent.RACE_100M.eventResultFormat(result.getRace100())));
		resElement.appendChild(writeElement("long-jump",DecathlonEvent.LONG_JUMP.eventResultFormat(result.getLongJump())));
		resElement.appendChild(writeElement("shot-put",DecathlonEvent.SHOT_PUT.eventResultFormat(result.getShotPut())));
		resElement.appendChild(writeElement("high-jump",DecathlonEvent.HIGH_JUMP.eventResultFormat(result.getHighJump())));
		resElement.appendChild(writeElement("race-400m",DecathlonEvent.RACE_400M.eventResultFormat(result.getRace400())));
		resElement.appendChild(writeElement("hurdles-110m",DecathlonEvent.HURDLES_110M.eventResultFormat(result.getHurdles110())));
		resElement.appendChild(writeElement("discus-throw",DecathlonEvent.DISCUS_THROW.eventResultFormat(result.getDiscusThrow())));
		resElement.appendChild(writeElement("pole-vault",DecathlonEvent.POLE_VAULT.eventResultFormat(result.getPoleVault())));
		resElement.appendChild(writeElement("javelin-throw",DecathlonEvent.JAVELIN_THROW.eventResultFormat(result.getJavelinThrow())));
		resElement.appendChild(writeElement("race-1500m",DecathlonEvent.RACE_1500M.eventResultFormat(result.getRace1500())));		
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
		if (competition.getDescription()==null) {
			compElement.appendChild(writeElement("description",competition.getDescription()));
		}
		if (!competition.getStringDate().isEmpty()) {
			compElement.appendChild(writeElement("date",competition.getStringDate()));			
		}
		if (competition.getCountryCode()==null){
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
	public static void main(String[] args) throws ParseException {
		XMLOutput xo = new XMLOutput();
		Competition c = OutputTest.singleCompetition();
		xo.writeData(c);
		try {
			xo.printXML(new FileOutputStream("test.xml"));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		xo.printXML(System.out);
	}

}
