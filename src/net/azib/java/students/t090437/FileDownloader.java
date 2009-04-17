package net.azib.java.students.t090437;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * FileDownloader
 *
 * @author Ronald
 */
public class FileDownloader extends BufferedCopyProgram 
							implements net.azib.java.lessons.io.FileDownloader {

	
	public void download(URL url, File destDir) throws IOException {
		URLConnection urlConn = url.openConnection();
		InputStream in = urlConn.getInputStream();
		OutputStream out;
		String fileName;
		String[] temp;
		
		fileName = url.getPath();
		if(fileName.length() > 3 && fileName.split("\\.").length > 1) {
			temp = fileName.split("/");
			fileName = temp[temp.length - 1];
		} else {
//			In this case there was no name, '.' and extension
//			in the file name
//			which means we do not know the file type from
//			the file name. In SOME case using the part after "/"
//			in Content-Type as file extension is OK.
			System.out.println(urlConn.getHeaderField("Content-Type"));
			temp = urlConn.getHeaderField("Content-Type").split(";");
			temp = temp[0].split("/");
			fileName = "downloaded."  + temp[1];
		}
		
		File destFile = new File(destDir, fileName);
		out = new FileOutputStream(destFile);
		
		copy(in, out);
	}
	
	public static void main(String[] args) {
		try {
			(new FileDownloader()).download(new URL("http://www.hot.ee/ronn"), new File("F:\\"));
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
