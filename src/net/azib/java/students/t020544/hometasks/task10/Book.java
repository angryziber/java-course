package net.azib.java.students.t020544.hometasks.task10;

import java.util.ArrayList;
import java.util.List;

/**
 * Book
 *
 * @author Julija Kondratjeva
 */
public class Book {
	
	private String category;
	private String lang;
	private String title;
	private List<String> author = new ArrayList<String>();
	private int year;
	private double price;
	
	
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * @return the author
	 */
	public List<String> getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void addAuthor(String author) {
		this.author.add(author);
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 
	 */
	public void print(Book book) {
		System.out.println("CATEGORY: " + book.getCategory());
		System.out.println("LANGUAGE: " + book.getLang());
		System.out.println("        TITLE: " + book.getTitle());
		System.out.println("        AUTHOR: " + book.getAuthor());
		System.out.println("        YEAR: " + book.getYear());
		System.out.println("        PRICE: " + book.getPrice());

	}

	
	

}
