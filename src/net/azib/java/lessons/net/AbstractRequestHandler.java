package net.azib.java.lessons.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base class of {@link RequestHandler} implementations in order to make
 * implementing RequestHandlers easier.
 *
 * @author anton
 */
public abstract class AbstractRequestHandler implements RequestHandler, Cloneable {

	private static final Pattern REQUEST_PARSER_PATTERN = Pattern.compile("^(GET|POST) (.+) HTTP");
	protected static final String ENCODING = "UTF-8";

	protected Socket socket;
	protected String requestString;
	protected String requestPath;

	@Override
	public String readRequest() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), ENCODING));
			String line;
			StringBuilder input = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty())
					break;
				input.append(line).append('\n');
			}
			requestString = input.toString();
			
			Matcher m = REQUEST_PARSER_PATTERN.matcher(input);
			if (!m.find()) {
				throw new IllegalArgumentException("InvalidRequest");
			}
			requestPath = m.group(2); 
			return requestPath;
		}
		catch (IOException e) {
			throw new IllegalArgumentException("Cannot read :-(", e);
		}
	}

	@Override
	public final AbstractRequestHandler cloneForRequest(Socket socket) {
		try {
			AbstractRequestHandler rh = (AbstractRequestHandler) clone();
			rh.socket = socket;
			return rh;
		}
		catch (CloneNotSupportedException e) {
			// never gonna happen (our class is Cloneable)
			return null;
		}
	}

}
