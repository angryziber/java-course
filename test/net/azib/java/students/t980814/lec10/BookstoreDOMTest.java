package net.azib.java.students.t980814.lec10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


/**
 * BookstoreDOMTest
 *
 * @author allan
 */
public class BookstoreDOMTest {

	final static String TEST_XML = "testbook.xml";
	
	@Test
	public void testCorrectBook() {
		Document xmldoc = new DocumentImpl();
		Element root = xmldoc.createElement("bookstore");
		Element book = null;
		Element e = null;
		Node n = null;

		book = xmldoc.createElement("book");
   	    book.setAttribute("category", "COMPUTERS");
		book.setAttribute("lang", "en");

		e = xmldoc.createElement("title");
		n = xmldoc.createTextNode("Art of Computer Programming");
		e.appendChild(n);
		book.appendChild(e);

		e = xmldoc.createElement("author");
		n = xmldoc.createTextNode("Donald Knuth");
		e.appendChild(n);
		book.appendChild(e);
		
		e = xmldoc.createElement("year");
		n = xmldoc.createTextNode("1998");
		e.appendChild(n);
		book.appendChild(e);

		e = xmldoc.createElement("price");
		n = xmldoc.createTextNode("152.00");
		e.appendChild(n);
		book.appendChild(e);

		root.appendChild(book);

		xmldoc.appendChild(root);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(TEST_XML);
			OutputFormat of = new OutputFormat("XML","UTF-8",true);
			of.setIndent(1);
			of.setIndenting(true);
			XMLSerializer serializer = new XMLSerializer(fos,of);
			serializer.asDOMSerializer();
			serializer.serialize( xmldoc.getDocumentElement() );
			fos.close();
			
			File testfile = new File(TEST_XML);
			InputStream source = new FileInputStream(testfile);
			BookstoreDOM bookStore = new BookstoreDOM(source);
			source.close();
			//System.out.println(bookStore);
			
			final String LN = System.getProperty("line.separator");
			assertEquals("Category: COMPUTERS / en" + LN +
					     "Art of Computer Programming [1998] - $152.0" + LN +
					     "[Donald Knuth]" + LN,
					     bookStore.toString());

			testfile.delete();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
}
