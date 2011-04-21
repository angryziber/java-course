package net.azib.java.students.t093759.hometasks.nineth;

import net.azib.java.lessons.io.DataCopier;
import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author dionis
 *         4/21/11 12:09 PM
 */
public class FileDownloaderImplTest {
	FileDownloaderImpl downloader;
	private DataCopier dataCopier;

	@Before
	public void setUpDownloader() throws IOException {
		//dataCopier = new BufferedCopyProgram();
		dataCopier = mock(DataCopier.class);
		//when(dataCopier.copy(any(InputStream.class), any(OutputStream.class))).thenAnswer("11");

		//Mockito.
		downloader = new FileDownloaderImpl(dataCopier);
	}

	@Test(expected = IOException.class)
	public void destDirShouldBeADir() throws IOException {
		downloader.download(getSomeGoodUrl(), createTempFile());
	}

	@Test(expected = IOException.class)
	public void destinationFileShouldNotExist() throws IOException {
		downloader.download(getSomeGoodUrl(), createTempFile());
	}

	@Test
	public void downloadExample() throws IOException, URISyntaxException {
		URL url = getSomeGoodUrl();
		File destDir = new File(getTmpPath());
		File destFile = new File(destDir, FilenameUtils.getName(url.getPath()));
		if (destFile.exists()) destFile.delete();

		downloader.download(url, destDir);
		verify(dataCopier).copy(any(InputStream.class), any(OutputStream.class));
	}

	private File createTempFile() throws IOException {
		File tempFile = File.createTempFile("t093759", "tmp");
		tempFile.deleteOnExit();
		return tempFile;
	}


	private String getTmpPath() {
		return System.getProperty("java.io.tmpdir");
	}

	private URL getSomeGoodUrl() throws MalformedURLException {
		//TODO improve that with mocks or something
		return new File("build.xml").toURI().toURL();
	}
}
