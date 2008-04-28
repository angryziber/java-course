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

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 21.04.2008
 * <br>Time: 13:55:32
 */
public class DOMParser implements XMLParser {
    private final String xmlResource;

    public DOMParser(String xmlResource) {
        this.xmlResource = xmlResource;
    }

    public List<Book> parse() throws IOException, SAXException, ParserConfigurationException {
        BookCreator bookCreator = new BookCreator();

        Document doc = readDocument(xmlResource);

        NodeList books = doc.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            parseBook((Element) books.item(i), bookCreator);
        }

        return bookCreator.getBooks();
    }

    private void parseBook(Element bookElement, BookCreator bookCreator) {
        bookCreator.initBook();

        /* Process ATTRIBUTES */
        bookCreator.setCategory(bookElement.getAttribute("category"));
        bookCreator.setLang(bookElement.getAttribute("lang"));

        /* Process CHILDREN */
        bookCreator.setTitle(bookElement.getElementsByTagName("title").item(0).getTextContent());
        NodeList authors = bookElement.getElementsByTagName("author");
        for (int i = 0; i < authors.getLength(); i++){
            bookCreator.setAuthor(authors.item(i).getTextContent());
        }
        bookCreator.setYear(Integer.parseInt(bookElement.getElementsByTagName("year").item(0).getTextContent()));
        bookCreator.setPrice(Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent()));

        /* Create new BOOK */
        bookCreator.createBook();
        
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
