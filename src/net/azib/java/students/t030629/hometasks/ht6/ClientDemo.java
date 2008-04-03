package net.azib.java.students.t030629.hometasks.ht6;

import java.net.Socket;
import java.io.*;

/**
 * Client that connects to {@link net.azib.java.students.t030629.hometasks.ht6.ServerDemo},
 * requests a file from it and saves it to the file recieved as a constructor parameter.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 02.04.2008
 * <br>Time: 18:29:26
 */
public class ClientDemo implements Runnable {
    static final String FILE_REQUEST = "GET YOUR MEGAFILE";
    private static final String LN = System.getProperty("line.separator");
    private File dest;

    public ClientDemo(File dest) {
        this.dest = dest;
    }

    public void run() {
        FileOutputStream fos = null;
        Socket socket = null;
        try {
            /* Connect to server, request the hosted file and save it on local machine */
            socket = new Socket("localhost", ServerDemo.DEFAULT_PORT); // Connect
            socket.getOutputStream().write((FILE_REQUEST + LN).getBytes()); // Request
            InputStream in = socket.getInputStream();
            fos = new FileOutputStream(dest);
            new SimpleCopyProgram().copy(in, fos); // Save
        }
        catch (IOException e) {
            /* Ignore exceptions on client side*/
            e.printStackTrace();
        }
        finally {
            QuietCloser.closeQuietly(socket);
            QuietCloser.closeQuietly(fos);
        }
    }

    public static void main(String[] args) throws IOException {
        File tempFile4 = File.createTempFile("java-logo_SOCKET_", ".gif");
        new Thread(new ClientDemo(tempFile4)).start();
    }
}
