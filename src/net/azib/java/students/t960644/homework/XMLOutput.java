package net.azib.java.students.t960644.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * XMLOutput
 * 
 * @author Lembit
 */
public class XMLOutput {
	Document doc;

	public void writeData(Competition competition) {
		CreateDoc();
		CreateDocTree(competition);

	}
	
	protected Element writeLine(Result result) {
		Element resElement = doc.createElement("result");
		resElement.appendChild(writeElement("position",result.getPosition()));
		resElement.appendChild(writeElement("score",Integer.toString(result.calcResult())));
		resElement.appendChild(writeElement("athlete",result.getAthlete().getName()));
		resElement.appendChild(writeElement("born",result.getAthlete().getBorn().toString()));
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
		resElement.appendChild(writeElement("race-1500m",DecathlonEvent.RACE_1500M.eventResultFormat(result.getRace1500()*1000)));		
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
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void CreateDocTree(Competition competition) {
		Element rootElement = doc.getDocumentElement();
		Element compElement = doc.createElement("competition");
		rootElement.appendChild(compElement);
		//compElement.appendChild(writeElement("description",competition.getDescription()));
		//compElement.appendChild(writeElement("date",competition.getDate().toString()));
		//compElement.appendChild(writeElement("location",competition.getCountryCode()));
		
		for (Result r:competition.getResults()) {
			compElement.appendChild(writeLine(r));
		}
	}
	public void printXML(OutputStream out) {
		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		format.setOmitXMLDeclaration(false); 
		format.setOmitDocumentType(false);
		

		XMLSerializer serializer = new XMLSerializer(out, format);

		try {
			serializer.serialize(doc);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				out.flush();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	public static void main(String[] args) {
		XMLOutput xo = new XMLOutput();
		Result res = new Result();
		Athlete a = new Athlete();
		a.setName("Peeter Pauksoo");
		a.setBorn(Date.valueOf("1950-05-01"));
		a.setCountryCode("EE");
		res.setAthlete(a);
		res.setPosition("1");
		res.setRace100(10.60);
		res.setLongJump(7.63);
		res.setShotPut(14.90);
		res.setHighJump(2.03);
		res.setRace400(46.23);
		res.setHurdles110(14.40);
		res.setDiscusThrow(43.40);
		res.setPoleVault(5.40);
		res.setJavelinThrow(67.01);
		res.setRace1500(269.58);
		Competition c = new Competition();
		c.setDate(Date.valueOf("2007-06-01"));
		c.setCountryCode("EE");
		c.setDescription("Kükametsa");
		c.addAthlete(a);
		c.addResult(res);
		xo.writeData(c);
		try {
			xo.printXML(new FileOutputStream("test.xml"));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//xo.printXML(System.out);
	}

}
