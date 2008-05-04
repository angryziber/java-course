package net.azib.java.students.t030633.hometasks.xml;

import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Bookstore
 * 
 * @author t030633
 */
public class Bookstore {

	private Collection<Book> books;

	public Bookstore() {
		this.books = new LinkedList<Book>();
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public Collection<Book> getAllBooks() {
		return books;
	}

	public void printOut(PrintStream out) {
		for (Book book : books) {
			book.printOut(out);
			out.println();
		}
	}

}
