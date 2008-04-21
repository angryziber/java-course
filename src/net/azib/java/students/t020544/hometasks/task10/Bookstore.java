package net.azib.java.students.t020544.hometasks.task10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Bookstore
 * 
 * @author Julija Kondratjeva
 */
public class Bookstore {
	List<Book> bookstore = new ArrayList<Book>();

	/**
	 * @return the bookstore
	 */
	public List<Book> getBookstore() {
		return bookstore;
	}

	/**
	 * @param bookstore
	 *            the bookstore to set
	 */
	public void addBook(Book book) {
		this.bookstore.add(book);
	}

	public void print() {
		System.out.println("Bookstore has " + bookstore.size() + " books.");
		System.out.println();
		for (Iterator iterator = bookstore.iterator(); iterator.hasNext();){
			Book book = (Book) iterator.next();
			book.print(book);
			System.out.println();
		}
	}

}
