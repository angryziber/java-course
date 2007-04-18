package net.azib.java.students.t050657.Home;

import java.util.ArrayList;
import java.util.List;

/**
 * Bookstore
 *
 * @author Boriss
 */
public class Bookstore {
	
	public List<Book> books = new ArrayList<Book>();
	
	public void addBook(Book book) {
		books.add(book);
	}

}
