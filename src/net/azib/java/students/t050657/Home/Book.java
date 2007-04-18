package net.azib.java.students.t050657.Home;

import java.util.ArrayList;
import java.util.List;

/**
 * Book
 *
 * @author Boriss
 */
public class Book {

	private String category;
	private String lang;
	private String title;
	
	private List<String> author = new ArrayList<String>();
	private int year;
	private double price;
	
	public List<String> getAuthor() {
		return author;
	}
	public void addAuthor(String a) {
		author.add(a);
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
