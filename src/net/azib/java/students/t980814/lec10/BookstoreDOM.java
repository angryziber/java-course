package net.azib.java.students.t980814.lec10;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * BookstoreDOM
 *
 * @author allan
 */
public class BookstoreDOM {

	static HashSet<Book> bookstore;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream source = BookstoreDOM.class.getResourceAsStream("books.xml");
		NodeList books = DocumentBuilderFactory.newInstance().
												newDocumentBuilder().
												parse(source).
												getDocumentElement().
												getChildNodes();
		source.close();
		
		bookstore = new HashSet<Book>();
		
		for (int i = 0; i < books.getLength(); i++) {
			Node node = books.item(i);
			if (!(node instanceof Element))
				continue;
			Element bookNode = (Element)node;

			Book book = new Book(bookNode.getElementsByTagName("title").item(0).getTextContent(),
								 bookNode.getAttribute("category"),
								 bookNode.getAttribute("lang"));
			for (int j = 0; j < bookNode.getElementsByTagName("author").getLength(); j++)
				book.addAuthor(bookNode.getElementsByTagName("author").item(j).getTextContent());
			book.setYear(new Integer(bookNode.getElementsByTagName("year").item(0).getTextContent()));
			book.setPrice(new Double(bookNode.getElementsByTagName("price").item(0).getTextContent()));
			bookstore.add(book);
		}
		
		for (Book book : bookstore) {
			System.out.println(book);
			System.out.println("---");
		}
	}

}
