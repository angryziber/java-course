package net.azib.java.students.t980814.lec10;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Book
 *
 * @author allan
 */
public class Book {

	String 				title;
	LinkedList<String>  authors;
	int 				year;
	double 				price;
	
	String				category;
	String				lang;
	
	Book(String title, String category, String lang) {
		this.category = category;
		this.lang = lang;
		setTitle(title);
	}
	
	Book(String title, String category, String lang, Collection<String> authors) {
		this(title, category, lang);
		for (String author : authors)
			addAuthor(author);
	}
	
	Book(String title, String category, String lang, Collection<String> authors, int year) {
		this(title, category, lang, authors);
		setYear(year);
	}

	Book(String title, String category, String lang, Collection<String> authors, int year, double price) {
		this(title, category, lang, authors, year);
		setPrice(price);
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void addAuthor(String author) {
		if (!(authors instanceof LinkedList))
			authors = new LinkedList<String>();
		authors.add(author);
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
