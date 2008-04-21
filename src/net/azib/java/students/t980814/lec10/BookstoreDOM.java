package net.azib.java.students.t980814.lec10;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * BookstoreDOM
 *
 * @author allan
 */
public class BookstoreDOM {

	private HashSet<Book> bookstore;
	
	BookstoreDOM(InputStream source) {
		NodeList books;

		try {
			books = DocumentBuilderFactory.newInstance().
										newDocumentBuilder().
										parse(source).
										getDocumentElement().
										getChildNodes();
			
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
		}
		catch (Exception e) {
			
		}
/*		finally { 
			closeQuietly(source);
		}*/
	}
	
/*	private void closeQuietly(InputStream source) {
		try {
			if (source != null) 
				source.close();
		}
		catch (IOException e) {
		}
	} */

	@Override
	public String toString() {
		final String LN = System.getProperty("line.separator");;
		StringBuilder text = new StringBuilder();
		for (Book book : bookstore)
			text.append(book + LN);
		return text.toString();
	}
	
	public static void main(String[] args) throws IOException {
		InputStream source = BookstoreDOM.class.getResourceAsStream("books.xml");
		BookstoreDOM bookStore = new BookstoreDOM(source);
		source.close();
		System.out.println(bookStore);
	}
}
