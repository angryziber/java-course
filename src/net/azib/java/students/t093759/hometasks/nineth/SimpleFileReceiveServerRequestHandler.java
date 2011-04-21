package net.azib.java.students.t093759.hometasks.nineth;

import net.azib.java.lessons.io.FileDownloader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
* @author dionis
*         4/21/11 1:41 PM
*/
class SimpleFileReceiveServerRequestHandler implements Runnable {
	Socket socket;
	FileDownloader fileDownloader;

	SimpleFileReceiveServerRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			//TODO implement this
			//
			//i.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}


	}
}
