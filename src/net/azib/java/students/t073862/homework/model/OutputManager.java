package net.azib.java.students.t073862.homework.model;

import net.azib.java.students.t073862.homework.Main;
import net.azib.java.students.t073862.homework.util.Util;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.w3c.dom.Document;

/**
 * OutputManager, manages output formatting
 *
 * @author Pets
 */
public class OutputManager {
	
	private StringTemplateGroup group = new StringTemplateGroup("Group Name",Main.class.getResource("").getFile().replace("%20", " "));
	
	
	/**
	 * Outputs to the console
	 * @param scores
	 */
	public void toConsole(Score[] scores) {
		int i = 1;
		for(Score s : scores) {
			System.out.println(i++ + "." + s);
		}
	}
	/**
	 * Outputs scores in XML format to file f
	 * @param scores
	 * @param f
	 */
	public void toXML(Score[] scores, File f) {
		StringTemplate tmp = group.getInstanceOf("XML");
		tmp.setAttribute("scores", scores);
		Util.writeToFile(f,tmp.toString());
	}
	/**
	 * Outputs scores in CSV format to file f
	 * @param scores
	 * @param f
	 */	
	public void toCSV(Score[] scores, File f) {
		StringTemplate tmp = group.getInstanceOf("CSV");
		tmp.setAttribute("scores", scores);
		Util.writeToFile(f,tmp.toString());
	}
	/**
	 * Outputs scores in HTML format to file f
	 * @param scores
	 * @param f
	 */
	public void toHTML(Score[] scores, File f) {
		this.toXML(scores, Util.getOutputFile("output.xml"));
		try {
			Document doc = Util.loadDocument("output.xml");
			
			StreamSource xslSource = new StreamSource(Main.class.getResourceAsStream("output.xsl"));
			Transformer template = TransformerFactory.newInstance().newTransformer(xslSource);
			
			template.transform(new DOMSource(doc), new StreamResult(f));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
