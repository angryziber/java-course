package net.azib.java.lessons.net;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class InsecureFileProvider implements ContentProvider {
	public boolean provide(String fileName, OutputStream out) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) return false;

		FileInputStream in = new FileInputStream(file);
		IOUtils.copy(in, out);
		in.close();
		return true;
	}
}
