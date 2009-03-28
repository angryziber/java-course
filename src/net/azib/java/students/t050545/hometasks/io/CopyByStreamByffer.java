package net.azib.java.students.t050545.hometasks.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



/**
 * CopyByStreamByffer
 *
 * @author libricon
 */
public class CopyByStreamByffer implements FileCopier{
	public void copy (File input, File output) throws IOException {
		if(input.exists()== true && input.isFile() == true && input.canRead() ){
			FileInputStream fileIn = new FileInputStream(input);
			FileOutputStream fileOut = new FileOutputStream(output);
			BufferedInputStream fileInput = new BufferedInputStream((InputStream)fileIn);
			BufferedOutputStream fileOutput = new BufferedOutputStream((OutputStream)fileOut);
			
			byte[] buf = new byte[4096];
			int len;
 			while((len=fileInput.read(buf)) >= 0){
				fileOutput.write(buf, 0, len);
			}
			
			fileInput.close();
			fileOutput.close();
		}
		else{
			System.out.println("Something wrong with your files !!!");
			System.out.println("exist: "+input.exists());
			System.out.println("file: "+input.isFile());
			System.out.println("canRead: "+input.canRead());
		}
	}

}
