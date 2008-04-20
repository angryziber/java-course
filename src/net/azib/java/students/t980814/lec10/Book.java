package net.azib.java.students.t980814.lec10;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Book
 *
 * @author allan
 */
public class Book {

	private String				category;
	private String				lang;
	private String 				title;
	private LinkedList<String>  authors;
	private int 				year = 0;
	private double 				price = 0.0;
	
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

	@Override
	public String toString() {
		final String LN = System.getProperty("line.separator");;

		StringBuilder text = new StringBuilder();
		text.append("Category: " + category + " / " + lang + LN);
		text.append(title + ((year == 0) ? " -" : (" [" + year + "] -")) +
				            ((price == 0) ? " " : " $" + price) + LN);
		text.append(authors);
		return text.toString();
	}

	
}
