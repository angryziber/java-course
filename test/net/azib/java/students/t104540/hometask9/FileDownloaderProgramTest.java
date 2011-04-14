package net.azib.java.students.t104540.hometask9;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileDownloaderProgramTest {

	@Test
	public void FileDownloadedTest() throws IOException {
		URL url  = new URL("http://java.azib.net/2011/8-io.pdf");
		String [] contents = url.getFile().split("/");
		File downloadedFile = File.createTempFile(contents[contents.length-1],null);
		FileDownloaderProgram fileDownloader = new FileDownloaderProgram();
		fileDownloader.download(url, downloadedFile);

		assertThat(downloadedFile.exists(), is(true));

		downloadedFile.deleteOnExit();
	}
}
