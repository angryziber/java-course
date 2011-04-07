package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.OutputStream;

public class NotFoundProvider implements ContentProvider {
	@Override
	public boolean provide(String fileName, OutputStream out) throws IOException {
		out.write(("<h1>" + fileName + " not found!</h1>").getBytes("UTF-8"));
		return true;
	}
}
