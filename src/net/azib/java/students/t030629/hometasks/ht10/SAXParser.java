package net.azib.java.students.t030629.hometasks.ht10;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 28.04.2008
 * <br>Time: 13:51:15
 */
public class SAXParser extends DefaultHandler implements XMLParser {
    private final String xmlResource;
    private BookCreator bookCreator;
    // Current Node under porocessing (State of SAX parser)
    private NodeType currentNode;

    public SAXParser(String xmlResource) {
        this.xmlResource = xmlResource;
        bookCreator = new BookCreator();
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNode = NodeType.valueOf(qName.toUpperCase());
        if (currentNode == NodeType.BOOK) {
            bookCreator.initBook();
            bookCreator.setCategory(attributes.getValue("category"));
            bookCreator.setLang(attributes.getValue("lang"));
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("book")) {
            bookCreator.createBook();
        }
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        String textNode = new String(ch, start, length).trim();
        /* Skip empty textNodes */
        if (textNode.length() == 0) return;
        switch (currentNode) {
            case TITLE:
                bookCreator.setTitle(textNode);
                break;
            case AUTHOR:
                bookCreator.setAuthor(textNode);
                break;
            case YEAR:
                bookCreator.setYear(Integer.parseInt(textNode));
                break;
            case PRICE:
                bookCreator.setPrice(Double.parseDouble(textNode));
                break;
            default:
                // do nothing
        }
    }

    public List<Book> parse() throws IOException, SAXException, ParserConfigurationException {
        InputStream sourceXml = SAXParser.class.getResourceAsStream(xmlResource);
        SAXParserFactory.newInstance().newSAXParser().parse(sourceXml, this);
        return bookCreator.getBooks();
    }

    private enum NodeType { BOOKSTORE, BOOK, TITLE, AUTHOR, YEAR, PRICE }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        List<Book> books = new SAXParser("/net/azib/java/lessons/xml/books.xml").parse();
        for (Book book : books) {
            System.out.println(book);
        }

    }
}
