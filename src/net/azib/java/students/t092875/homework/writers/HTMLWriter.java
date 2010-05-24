package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

/**
 * HTMLWriter
 *
 * @author Mihhail
 */
public class HTMLWriter extends XMLWriter{
	/**
	 * Creates a HTMLWriter object
	 * @param filename - html file where the results are writen to
	 */
	public HTMLWriter(String filename){
		super(filename);
	}
	/**
	 * writes the results of the decathlon to a html file
	 * @param athletes - List of athletes who participated in the competition
	 */
	public void write(List<Athlete> athletes){
		Document doc = this.generateXML(athletes);
		StreamSource xslSource = new StreamSource(HTMLWriter.class.getResourceAsStream("athletes.xsl"));
		OutputStreamWriter writer = null;
		try {
			Transformer template = TransformerFactory.newInstance().newTransformer(xslSource);
			File html = new File(this.filename);
			html.createNewFile();
			FileOutputStream fos = new FileOutputStream(html);
			writer = new OutputStreamWriter(fos, Charset.forName("UTF-8"));
			StreamResult s = new StreamResult();
			s.setWriter(writer);
			template.transform(new DOMSource(doc), s);
			writer.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				writer.close();
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
