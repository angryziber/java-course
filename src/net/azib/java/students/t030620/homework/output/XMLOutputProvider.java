package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.util.CompetitionUtil;
import net.azib.java.students.t030620.homework.util.Utils;

import java.io.File;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * XMLOutputProvider
 *
 * @author Lord HellBunny
 */
public class XMLOutputProvider implements OutputProvider {

	@Override
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception {
		File outputFile = (File)param;
		outputFile.createNewFile();
		Node root = getXML(scores);
		writeFile(outputFile, root);

	}
	
	public Node getXML(Collection<DecathleteScoreKeeper> scores) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		Element root = document.createElement("results");
		document.appendChild(root);
		
		for (DecathleteScoreKeeper score : scores) {
			Element result = document.createElement("result");
			root.appendChild(result);
			
			Element place = document.createElement("place");
			place.appendChild(document.createTextNode(score.getPlace()));
			
			Element scored = document.createElement("score");
			scored.appendChild(document.createTextNode(""+score.getScore()));
			
			Element name = document.createElement("name");
			name.appendChild(document.createTextNode(score.getName()));
			
			Element date = document.createElement("date");
			date.appendChild(document.createTextNode(Utils.formatDate(score.getDate())));
			
			Element code = document.createElement("code");
			code.appendChild(document.createTextNode(score.getCountryCode()));
			
			result.appendChild(place);
			result.appendChild(scored);
			result.appendChild(name);
			result.appendChild(date);
			result.appendChild(code);
			
			
			for(Competition c : Competition.values()) {

				String output = CompetitionUtil.formatCompetitionResult(score.getScores().get(c), c);
				
				Element elem = document.createElement(c.name().toLowerCase());
				elem.appendChild(document.createTextNode(output));
				result.appendChild(elem);
			}
			
			
		}
		
		return root;
		
	}
	
	
	private void writeFile(File outputFile, Node root) throws TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(new DOMSource(root), new StreamResult(outputFile));
	}

}
