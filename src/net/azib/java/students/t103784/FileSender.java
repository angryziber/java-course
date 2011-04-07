package net.azib.java.students.t103784;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Ott
 * Date: 7.04.11
 * Time: 20:19
 * To change this template use File | Settings | File Templates.
 */
public class FileSender {
	public boolean provide(String fileName, OutputStream out) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) return false;

		FileInputStream in = new FileInputStream(file);
		BufferedCopyProgram.copy(in, out);
		in.close();
		return true;
	}
}
