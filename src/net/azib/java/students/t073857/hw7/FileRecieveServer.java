package net.azib.java.students.t073857.hw7;

import net.azib.java.students.t073857.hw6.BufferedCopyProgram;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * FileRecieverServer
 *
 * @author Joonas Vali
 */
public class FileRecieveServer extends BufferedCopyProgram {	
	
	public void reciever(int port, File dest) throws IOException{			
		ServerSocket server = new ServerSocket(port);
		Socket s = server.accept();		
		String name = getName(s.getInputStream());
		if(name == null) throw new IOException("Reading failed!");
		FileOutputStream output = new FileOutputStream(new File(dest,name));
		copy(s.getInputStream(), output);		
		s.close();		
		output.close();
		System.out.println("File transfer successful!");
	}
	
	public String getName(InputStream input){		
		StringBuilder s = new StringBuilder();
		int b;
		try{			
			int size =input.read(); //first byte is a size of the name
			for(int i = 0 ; i < size; i++){
				b=input.read();
				s.append((char)b);
			}
		}catch(IOException e){			
			return null;			
		}
		return s.toString();
	}
}
