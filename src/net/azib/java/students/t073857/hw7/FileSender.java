package net.azib.java.students.t073857.hw7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * FileSender
 *
 * @author Joonas Vali
 */
public class FileSender {
	
	InetAddress address;
	int port;
	
	public FileSender(InetAddress address, int port) {
		this.address = address;
		this.port = port;
	}

	public void send(File file) throws IOException{		
		InetSocketAddress socketAddress = new InetSocketAddress(address, port);
		Socket s = new Socket(); 
		try{
			s.connect(socketAddress, 5000);		
			BufferedOutputStream output = new BufferedOutputStream(s.getOutputStream());
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
			output.write(file.getName().getBytes().length); // send file name length
			output.write(file.getName().getBytes()); // send file name			
			int b;			
			while((b=input.read())!=-1){
				output.write(b);
			}			
			output.close();
			input.close();
			System.out.println("File transfer successful!");
		}catch(ConnectException e){
			System.err.println("Error, connection refused.");
		}finally{			
			s.close();
		}
	}
}
