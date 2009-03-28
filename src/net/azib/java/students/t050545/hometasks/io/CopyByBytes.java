package net.azib.java.students.t050545.hometasks.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;




/**
 * copyByBytes
 *
 * @author libricon
 */
public class CopyByBytes implements FileCopier{
	
	public void copy (File input, File output) throws IOException {
		if(input.exists()== true && input.isFile() == true && input.canRead() ){
			FileInputStream fileInput = new FileInputStream(input);
			FileOutputStream fileOutput = new FileOutputStream(output);
			
			while(fileInput.available() != 0){
				fileOutput.write(fileInput.read());
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
