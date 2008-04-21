package net.azib.java.students.t030629.hometasks.ht10;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 21.04.2008
 * <br>Time: 13:55:32
 */
public class DOMParser {
    private final String xmlResource;

    public DOMParser(String xmlResource) {
        this.xmlResource = xmlResource;
    }

    private List<Book> parse() throws IOException, SAXException, ParserConfigurationException {
        List<Book> bookList = new LinkedList<Book>();

        Document doc = readDocument(xmlResource);

        NodeList books = doc.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            parseBook((Element) books.item(i), bookList);
        }

        return bookList;
    }

    private void parseBook(Element bookElement, List<Book> bookList) {
        String category, lang, title;
        List<String> authorList = new LinkedList<String>();
        int year;
        double price;


        /* Process ATTRIBUTES */
        category = bookElement.getAttribute("category");
        lang = bookElement.getAttribute("lang");

        /* Process CHILDREN */
        title = bookElement.getElementsByTagName("title").item(0).getTextContent();
        NodeList authors = bookElement.getElementsByTagName("author");
        for (int i = 0; i < authors.getLength(); i++){
            authorList.add(authors.item(i).getTextContent());
        }
        year = Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent());
        price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());


        /* Create new BOOK and add it to bookList*/
        bookList.add(new Book(category, lang, title, authorList, year, price));
    }

    private Document readDocument(String xmlResource) throws IOException, ParserConfigurationException, SAXException {
        InputStream source = null;
        Document document = null;
        try {
            source = DOMParser.class.getResourceAsStream(xmlResource);
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(source);
        } finally {
            if (source != null) {
                source.close();
            }
        }

        return document;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        List<Book> books = new DOMParser("/net/azib/java/lessons/xml/books.xml").parse();
        for (Book book : books) {
            System.out.println(book);
        }
    }

}
