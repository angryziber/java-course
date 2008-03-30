package net.azib.java.students.t040719.lessons;

import net.azib.java.lessons.io.FileCopier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


/**
 * MappingCopyProgram
 *
 * @author romi
 */
public class MappingCopyProgram implements FileCopier {

	
	public void copy(File src, File dest) throws IOException {
		FileInputStream fis = null;
		RandomAccessFile fos = null;
		try {
			
			fis = new FileInputStream(src);
			FileChannel rc = fis.getChannel();
			MappedByteBuffer inBuf = rc.map(FileChannel.MapMode.READ_ONLY, 0, rc.size());
	
			fos = new RandomAccessFile(dest, "rw");
			FileChannel wc = fos.getChannel();
			MappedByteBuffer outBuf = wc.map(FileChannel.MapMode.READ_WRITE, 0, rc.size());
			
			outBuf.put(inBuf);
		}
		finally {
			try {
		        if (fis != null) fis.close();
		      }
		      catch (IOException e) {}
		      try {
		        if (fos != null) fos.close();
		       }
		      catch (IOException e) {}
		}
	}
}
