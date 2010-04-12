package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.Writer;

/**
 * RequestHandler
 *
 * @author anton
 */
public interface RequestHandler {

	public void handle(String request, Writer writer) throws IOException;

}