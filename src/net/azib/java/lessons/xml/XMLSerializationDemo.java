package net.azib.java.lessons.xml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * XMLSerializationDemo
 *
 * @author anton
 */
public class XMLSerializationDemo {
	public static void main(String[] args) throws Exception {
		Document doc = DOMDemo.loadDocument("books.xml");
		doc.getDocumentElement().setAttribute("processed", "true");
		
		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.transform(new DOMSource(doc), new StreamResult(System.out));
		
	}
}
