package net.azib.java.lessons.xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

/**
 * XMLSerializationDemo
 *
 * @author anton
 */
public class XSLDemo {
	public static void main(String[] args) throws Exception {
		Document doc = DOMDemo.loadDocument("books.xml");
		
		StreamSource xslSource = new StreamSource(XSLDemo.class.getResourceAsStream("books.xsl"));
		Transformer template = TransformerFactory.newInstance().newTransformer(xslSource);
		
		template.transform(new DOMSource(doc), new StreamResult(System.out));
	}
}
