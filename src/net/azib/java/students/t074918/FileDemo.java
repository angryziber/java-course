package net.azib.java.students.t074918;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;


/**
 * FileDemo
 *
 * @author Mart Mangus
 */
public class FileDemo {
	
	public static void main(String[] args) {
		File f = new File(".classpath");
		System.out.println("Name: " + f);
		System.out.println("Full path: " + f.getAbsolutePath());
		System.out.println("Exists: " + f.exists());

		/**
		 * *Steam -- bittide info
		 * *Reader -- UNICODE tekst ja nii
		 */
		
		BufferedReader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(createInputStream(f)));
			readAndDisplay(r);
		}
		catch (IOException e) {
			System.err.println("Ei saa faili avada!");
		}
		finally {
			try {
				r.close();	
			}
			catch (Exception e2) {
				// võib ignoreerida
			}
			/** Ilusam versioon: */
			IOUtils.closeQuietly(r);
		}

	}

	/**
	 * @param f
	 * @return
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	private static InputStream createInputStream(File f) throws MalformedURLException, IOException {
		//return new InputStreamReader(new FileInputStream(f), "UTF-8");
		return new URL("http://neti.ee").openStream();
	}
	
	private static void readAndDisplay(Reader reader) throws IOException
	{
		char[] buf = new char[500];
		int len;
		while ((len = reader.read(buf)) != -1)
		{
			System.out.print(new String(buf, 0, len));
		}
		
		/**
		 * IOUtils -- Mugav aga ebastandardne
		 * Liiga suurte failidega aga ei ole sobilik... siis striimida nagu üleval...
		 */
		System.out.println(IOUtils.toString(reader));
		
		/**
		 * IOException -- pöörata palju tähelepanu, väga tihti esinev
		 */
	}

	/**
	 * Piped -- thread-ide ühendamiseks...
	 */
}
