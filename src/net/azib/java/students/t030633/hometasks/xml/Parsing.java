package net.azib.java.students.t030633.hometasks.xml;

import java.io.File;
import java.util.Scanner;

/**
 * Parsing
 * 
 * @author t030633
 */
public class Parsing {

	public static void main(String[] args) throws Exception {

		System.out.println("Select parser: ");
		System.out.println("1) DOM");
		System.out.println("2) SAX");
		System.out.println("3) Apache Digester");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		XMLParser parser;

		switch (n) { // XML parsers
		default:
			parser = new DOMBookParser();
			break;
		case 2:
			parser = new SAXBookParser();
			break;
		case 3:
			parser = new ApacheDigesterParser();
			break;
		}

		// See SDN bug 4466485.
		File file = new File(Parsing.class.getResource("books.xml").toURI().getPath());
		parser.parse(file).printOut(System.out);

	}

}