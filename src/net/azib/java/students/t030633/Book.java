package net.azib.java.students.t030633;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * Book
 * 
 * @author t030633
 */
public class Book {

	private final String LN = System.getProperty("line.separator");

	public enum BookCategory {
		COOKING, LITERATURE, CHILDREN, COMPUTERS;
	}

	private BookCategory category;
	private Locale lang;
	private String title;
	private List<String> authors;
	private int year;
	private double price;

	public Book() {
		authors = new LinkedList<String>();
	}

	public void printOut(PrintStream out) {
		out.println("-=[" + title + "]=-");
		out.println("  (" + lang.toString() + ", " + category.toString() + ")");
		out.print("  Authors: ");
		for (String s : authors) {
			out.print(s);
			if (s.compareTo(authors.get(authors.size() - 1)) != 0) {
				out.print(", ");
			}
		}
		out.println(LN + "  Year: " + year);
		out.println("  Price: " + price);
	}

	public void setCategory(String category) {
		this.category = BookCategory.valueOf(category);
	}

	public void setLang(String lang) {
		this.lang = new Locale(lang);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addAuthor(String author) {
		this.authors.add(author);
	}

	public void setYear(String year) {
		this.year = Integer.parseInt(year);
	}

	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}

}
