package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.OutputStream;

public class HelloWorldProvider implements ContentProvider {
	@Override
	public boolean provide(String fileName, OutputStream out) throws IOException {
		if (!fileName.contains("hello")) return  false;

		out.write("Hello World!".getBytes());
		return true;
	}
}
