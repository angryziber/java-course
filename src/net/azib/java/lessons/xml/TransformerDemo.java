package net.azib.java.lessons.xml;

import java.io.InputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * TransformerDemo
 *
 * @author anton
 */
public class TransformerDemo {
	public static void main(String[] args) throws Exception {
		InputStream stylesheet = DOMDemo.class.getResourceAsStream("books.xsl");
		Transformer transformer = TransformerFactory.newInstance().
				newTransformer(new StreamSource(stylesheet));
		stylesheet.close();
		
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml");
		transformer.transform(new StreamSource(source), new StreamResult(System.out));
		source.close();
	}
}
