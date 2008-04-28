package net.azib.java.students.t030629.hometasks.ht10;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.List;
import java.io.IOException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 28.04.2008
 * <br>Time: 13:53:54
 */
public interface XMLParser {
    List<Book> parse() throws IOException, SAXException, ParserConfigurationException;
}
