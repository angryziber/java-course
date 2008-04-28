package net.azib.java.students.t072054.hometask1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.azib.java.lessons.io.FileCopier;

import static org.junit.Assert.assertTrue;

import java.io.*;

/**
 * BufferedCopyProgram
 * 
 * @author r_vassiljev
 */
public class BufferedCopyProgram implements FileCopier{
		public void copy(File src, File dest) throws IOException {
			/**
			 * Opening file for reading
			 */
			FileReader fr = new FileReader(src);

			/**
			 * Creating new file for writing
			 */
			FileWriter fw = new FileWriter(dest);
			
			BufferedWriter bw = new BufferedWriter(fw);

			while (fr.ready()) {
				int temp;
				temp = fr.read();
				bw.write(temp);
			}

			fr.close();
			bw.close();
		}

		public static void main(String[] args) {
			File f1 = new File("C:\\source.txt");
			File f2 = new File("C:\\dest.txt");
			long time_start, time_end;

			BufferedCopyProgram bcp = new BufferedCopyProgram();

			try {
				time_start = System.currentTimeMillis();
				bcp.copy(f1, f2);
				time_end = System.currentTimeMillis();
				
				System.out.println(time_end - time_start);
			}
			catch (Exception e) {
				System.out.println("File exception");
			}
		}
	}

