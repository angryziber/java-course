package net.azib.java.students.t072054.hometask1.xml;

import java.io.File;

import org.apache.commons.digester.Digester;

/**
 * ApacheDigesterParser
 * 
 * @author t030633
 */
public class ApacheDigesterParser implements XMLParser {

	public Bookstore parse(File file) throws Exception {
		Digester digester = new Digester();
		digester.setValidating(false);

		digester.addObjectCreate("bookstore", Bookstore.class);

		digester.addObjectCreate("bookstore/book", Book.class);
		digester.addSetProperties("bookstore/book");
		digester.addCallMethod("bookstore/book/title", "setTitle", 0);
		digester.addCallMethod("bookstore/book/author", "addAuthor", 0);
		digester.addCallMethod("bookstore/book/year", "setYear", 0);
		digester.addCallMethod("bookstore/book/price", "setPrice", 0);
		digester.addSetNext("bookstore/book", "addBook");

		return (Bookstore) digester.parse(file);
	}

}