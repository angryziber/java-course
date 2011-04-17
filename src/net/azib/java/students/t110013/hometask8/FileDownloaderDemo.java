package net.azib.java.students.t110013.hometask8;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Vadim
 */
public class FileDownloaderDemo {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.swordandsworcery.com/storage/mingitaw2.png");
		URL url2 = new URL("http://www.swordandsworcery.com/storage/cabin.png");
		File dir = new File(System.getProperty("java.io.tmpdir"));

		try {
			new FileDownloaderImpl(1000, 1000).download(url, dir);
			new ApacheCommonsPoweredFileDownloaderImpl().download(url2, dir);

			System.out.println("Downloaded files can be found in " + dir);
		}
		catch (IOException e) {
			System.out.println("Something went wrong, probably files are no longer accessible.");
		}
	}
}
