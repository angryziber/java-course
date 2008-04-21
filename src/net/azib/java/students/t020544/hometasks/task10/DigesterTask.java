package net.azib.java.students.t020544.hometasks.task10;


import net.azib.java.lessons.xml.DOMDemo;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

/**
 * DigesterTask
 * 
 * @author Julija Kondratjeva
 */
public class DigesterTask {


	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		
		InputStream source = DigesterTask.class.getResourceAsStream("books.xml");
		
		Digester digester = new Digester();
		digester.setValidating(false);

		digester.addObjectCreate("bookstore", Bookstore.class);		
		digester.addSetProperties("bookstore");
		
		digester.addObjectCreate("bookstore/book", Book.class);
		
		digester.addSetProperties("bookstore/book", "category", "category");
		digester.addSetProperties("bookstore/book", "lang", "lang");		
		
		digester.addSetNestedProperties("bookstore/book");		

		digester.addCallMethod("bookstore/book/author", "addAuthor", 0);
	
		digester.addSetNext("bookstore/book", "addBook");
				

		Bookstore bookstore = (Bookstore) digester.parse(source);
		bookstore.print();

//		for(Book book : bookstore.bookstore) {
//			book.print(book);
//			System.out.println();

//		} 	
		

	}
}
