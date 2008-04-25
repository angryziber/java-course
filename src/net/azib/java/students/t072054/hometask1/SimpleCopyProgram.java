package net.azib.java.students.t072054.hometask1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.azib.java.lessons.io.FileCopier;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * SimpleCopyProgram
 * 
 * @author r_vassiljev
 */
public class SimpleCopyProgram implements FileCopier {

	public void copy(File src, File dest) throws IOException {
		/**
		 * Opening file for reading
		 */
		FileReader fr = new FileReader(src);

		/**
		 * Creating new file for writing
		 */
		FileWriter fw = new FileWriter(dest);

		while (fr.ready()) {
			int temp;
			temp = fr.read();
			fw.write(temp);
		}

		fr.close();
		fw.close();
	}

	public static void main(String[] args) {
		File f1 = new File("C:\\source.txt");
		File f2 = new File("C:\\dest.txt");
		File f3 = new File("C:\\dest2.txt");

		SimpleCopyProgram scp = new SimpleCopyProgram();
		BufferedCopyProgram bcp = new BufferedCopyProgram();

		try {
			scp.copy(f1, f2);
		}
		catch (Exception e) {
			System.out.println("File exception");
		}
	}
}
