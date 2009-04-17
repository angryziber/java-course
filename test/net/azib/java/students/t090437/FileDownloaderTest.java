package net.azib.java.students.t090437;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

/**
 * FileDownloaderTest
 *
 * @author Ronald
 */
public class FileDownloaderTest {
	@Test
	public void simpleFiledownload() {
		FileDownloader fd = new FileDownloader();
		File destDir = new File(System.getProperty("java.io.tmpdir"));
		File destFile;
		
		try {
			fd.download(new URL("http://www.hot.ee/ronn/skype2potscircuitboard.jpg"), destDir);
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		destFile = new File(System.getProperty("java.io.tmpdir") + "skype2potscircuitboard.jpg");
		
		assertTrue("downloading a file failed", (destFile.exists() && destFile.length() == 330771));
	}
	
	@Test
	public void downloadIndexWithNoFileName() {
		FileDownloader fd = new FileDownloader();
		File destDir = new File(System.getProperty("java.io.tmpdir"));
		File destFile;
		
		try {
			fd.download(new URL("http://google.ee"), destDir);
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		destFile = new File(System.getProperty("java.io.tmpdir") + "downloaded.html");
		
		assertTrue("downloading a file failed", destFile.exists());
		
		destFile.delete();	
	}

}
