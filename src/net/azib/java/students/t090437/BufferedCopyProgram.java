package net.azib.java.students.t090437;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * BufferedCopyProgram
 *
 * @author Ronald
 */
public class BufferedCopyProgram implements net.azib.java.lessons.io.FileCopier,
												net.azib.java.lessons.io.DataCopier {
	
	public void copy(File src, File dest) throws IOException {
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);
		
		copy(in, out);
		
		in.close();
		out.close();
	}

	public void copy(InputStream src, OutputStream dest) throws IOException {
		BufferedInputStream in = new BufferedInputStream(src);
		BufferedOutputStream out = new BufferedOutputStream(dest);
		
		byte[] buf = new byte[1024];
		int len;
		
		while((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		
		in.close();
		out.close();	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File orig = new File("F:\\LAMBI.FAIL");
		File copy = new File("F:\\KOOPIA.FAIL");
		BufferedCopyProgram scp = new BufferedCopyProgram();
		
		long starttime, stoptime;
		
		starttime = System.currentTimeMillis();
		try {
			scp.copy(orig, copy);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stoptime = System.currentTimeMillis();
		
		System.out.println("Copying time : " + new Long(stoptime - starttime));
	}
}
