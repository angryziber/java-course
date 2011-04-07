package net.azib.java.lessons.net;

import java.io.IOException;
import java.io.OutputStream;

public interface ContentProvider {
	boolean provide(String fileName, OutputStream out) throws IOException;
}
