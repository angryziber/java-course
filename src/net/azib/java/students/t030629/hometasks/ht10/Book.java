package net.azib.java.students.t030629.hometasks.ht10;

import java.util.List;
import java.util.Locale;
import java.util.Currency;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 21.04.2008
 * <br>Time: 14:07:40
 */
public class Book {
    private static final String LN = System.getProperty("line.separator");

    private String category;
    private final String title;
    private final List<String> authorList;
    private final int year;
    private double price;
    private Locale lang;

    public Book(String category, String lang, String title, List<String> authorList, int year, double price) {
        this.category = category;
        this.title = title;
        this.authorList = authorList;
        this.year = year;
        this.price = price;
        this.lang = new Locale(lang);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(title).append(LN);
        sb.append("Authors: ").append(LN);
        for (String author : authorList)
            sb.append('\t').append(author).append(LN);
        sb.append("Category: ").append(category).append(LN);
        sb.append("Language: ").append(lang.getLanguage()).append(LN);
        sb.append("Year: ").append(year).append(".\t").
                append("Price: ").append(price).append(" ").append(Currency.getInstance(Locale.getDefault())).
                append(LN);
        return sb.toString();
    }
}
