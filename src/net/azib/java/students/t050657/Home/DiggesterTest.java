package net.azib.java.students.t050657.Home;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

/**
 * DiggesterTest
 *
 * @author Boriss
 */
public class DiggesterTest {

	public static void main(String[] args) throws SAXException, IOException{
		
		InputStream in = DiggesterTest.class.getResourceAsStream("books.xml");

		Digester digester = new Digester();

		digester.addObjectCreate("bookstore", "net.azib.java.students.t050657.Home.Bookstore");
		
		digester.addSetProperties("bookstore");
		
		digester.addObjectCreate("bookstore/book", Book.class);
		digester.addSetNext("bookstore/book", "addBook", "net.azib.java.students.t050657.Home.Book");
				
		digester.addSetNestedProperties("bookstore/book", "book", "title");
		digester.addCallMethod("bookstore/book/author", "addAuthor", 0);
		digester.addSetNestedProperties("bookstore/book", "book", "year");
		digester.addSetNestedProperties("bookstore/book", "book", "price");
		
		digester.addSetProperties("bookstore/book", "category", "category");
		digester.addSetProperties("bookstore/book/title", "lang", "lang");

		Bookstore store = (Bookstore) digester.parse(in);
		for(Book book : store.books) {
			System.out.println(book.getTitle());
			System.out.println(book.getCategory());
			System.out.println(book.getLang());
			System.out.println(book.getAuthor());
			System.out.println(book.getPrice());
			System.out.println(book.getYear());
			System.out.println();
		} 	
		
	}
}
