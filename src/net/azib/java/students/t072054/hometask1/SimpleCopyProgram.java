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
		SimpleCopyProgram scp = new SimpleCopyProgram();

		try {
			scp.copy(f1, f2);
			filesAreIdentical(f1, f2);
		}
		catch (Exception e) {
			System.out.println("File exception");
		}
	}

	public static boolean filesAreIdentical(File left, File right) throws IOException {
		assert left != null;
		assert right != null;
		assert left.exists();
		assert right.exists();

		if (left.length() != right.length())
			return false;

		FileInputStream lin = new FileInputStream(left);
		FileInputStream rin = new FileInputStream(right);
		try {
			byte[] lbuffer = new byte[4096];
			byte[] rbuffer = new byte[lbuffer.length];
			for (int lcount = 0; (lcount = lin.read(lbuffer)) > 0;) {
				int bytesRead = 0;
				for (int rcount = 0; (rcount = rin.read(rbuffer, bytesRead, lcount - bytesRead)) > 0;) {
					bytesRead += rcount;
				}
				for (int byteIndex = 0; byteIndex < lcount; byteIndex++) {
					if (lbuffer[byteIndex] != rbuffer[byteIndex])
						return false;
				}
			}
		}
		finally {
			lin.close();
			rin.close();
		}
		return true;
	}
}
