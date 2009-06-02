package net.azib.java.students.t090437.homework;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.SortedSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * CompetitionResultXMLProducer
 * 
 * Class for generating XML file from the competitor data.
 *
 * @author Ronald
 */
public class CompetitionToXML implements CompetitionResultsProducer {
	private SortedSet<Competitor> competitors;
	private String outputFileName;
	private Source transformerSource;
	
	/**
	 * Creates new object for generating the XML to the location 
	 * specified by the parameter.
	 * 
	 * @param outputFileName
	 */
	public CompetitionToXML(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	
	/**
	 * Builds a XML document object from the competitors specified.
	 * @return
	 */
	private Document buildXMLDocument() {
		Document doc = null;
		Element root;
	
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		root = doc.createElement("competition");
		doc.appendChild(root);
		
		Element child;
		Element result;
		for ( Competitor competitor : competitors) {
			child = doc.createElement("competitor");
			child.setAttribute("name", competitor.getName());
			child.setAttribute("country", competitor.getCountry());
			child.setAttribute("birthday", competitor.getBirthdayStr());
			// TODO Add birthday attribute
			root.appendChild(child);
			
			result = doc.createElement("position");
			result.appendChild(doc.createTextNode(competitor.getPosition().toString()));
			child.appendChild(result);
			
			result = doc.createElement("score");
			result.appendChild(doc.createTextNode(Integer.toString(competitor.getScore())));
			child.appendChild(result);
			
			result = doc.createElement("sprint100m");
			result.appendChild(doc.createTextNode(competitor.getSprint_100m_s().toString()));
			child.appendChild(result);
			
			result = doc.createElement("long_jump");
			result.appendChild(doc.createTextNode(competitor.getLong_jump_m().toString()));
			child.appendChild(result);
			
			result = doc.createElement("shot_put");
			result.appendChild(doc.createTextNode(competitor.getShot_put_m().toString()));
			child.appendChild(result);
			
			result = doc.createElement("high_jump");
			result.appendChild(doc.createTextNode(competitor.getShot_put_m().toString()));
			child.appendChild(result);
			
			result = doc.createElement("sprint400m");
			result.appendChild(doc.createTextNode(competitor.getSprint_400m_m_s().toString()));
			child.appendChild(result);
			
			result = doc.createElement("hurdles");
			result.appendChild(doc.createTextNode(competitor.getHurdles_s().toString()));
			child.appendChild(result);
			
			result = doc.createElement("discus");
			result.appendChild(doc.createTextNode(competitor.getDiscus().toString()));
			child.appendChild(result);
			
			result = doc.createElement("pole_vault");
			result.appendChild(doc.createTextNode(competitor.getPole_vault().toString()));
			child.appendChild(result);
			
			result = doc.createElement("javelin_throw");
			result.appendChild(doc.createTextNode(competitor.getJavelin_throw().toString()));
			child.appendChild(result);
			
			result = doc.createElement("race1500m");
			result.appendChild(doc.createTextNode(competitor.getRace_1500m_m_s().toString()));
			child.appendChild(result);
		}		
		
		return doc;
	}
	
	/**
	 * Sets the source for the style sheet for transforming the XML document to file output.  
	 * @param source
	 */
	protected void setTransformerStylesheet(Source source) {
		this.transformerSource = source;
	}

	/**
	 * Creates the output file from the competitor data. If no style sheet was specified 
	 * then outputs a plain XML file with the name and location specified in the creation 
	 * of the object.
	 */
	@Override
	public void produceResults() throws MyException {
		Document doc = buildXMLDocument();
		
		try {
			Transformer trans;
			if(transformerSource == null) {
				trans = TransformerFactory.newInstance().newTransformer();
			} else {
				trans = TransformerFactory.newInstance().newTransformer(transformerSource);
			}
			Writer outputwriter = new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8");
			StreamResult streamresult = new StreamResult(outputwriter);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, streamresult);
			outputwriter.close();
		}
		catch (Exception e) {
			throw new MyException("Unable to produce XML output.\r\n" + e);
		}

	}

	/**
	 * Sets the competition data to be transformed to XML file. This must be done 
	 * before the results can be produced.
	 */
	public void setCompetitionResults(SortedSet<Competitor> competitors) {
		this.competitors = competitors;		
	}

}
