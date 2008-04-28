package net.azib.java.students.t030629.hometasks.ht10;

import java.util.List;
import java.util.LinkedList;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 28.04.2008
 * <br>Time: 14:36:31
 */
public class BookCreator {

    // List of parsed books
    private List<Book> books;
    // Fields for the book under processing
    private String category, lang, title;
    private List<String> authorList;
    private int year;
    private double price;

    public BookCreator() {
        books = new LinkedList<Book>();
    }

    public void initBook() {
        category = lang = title = null;
        authorList = new LinkedList<String>();
        year = 0;
        price = 0;
    }

    public void createBook() {
        books.add(new Book(category, lang, title, authorList, year, price));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setCategory(String value) {
        category = value;
    }

    public void setLang(String value) {
        lang = value;
    }

    public void setTitle(String value) {
        title = value;
    }

    public void setAuthor(String value) {
        authorList.add(value);
    }

    public void setYear(int i) {
        year = i;
    }

    public void setPrice(double v) {
        price = v;
    }

}
