package net.azib.java.students.t030629.hometasks.ht6;

import java.net.Socket;
import java.io.*;
import java.util.Scanner;

/**
 * Client that connects to {@link net.azib.java.students.t030629.hometasks.ht6.ServerDemo},
 * requests a file from it and saves it to the file recieved as a constructor parameter.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 02.04.2008
 * <br>Time: 18:29:26
 */
public class ClientDemo implements Runnable {
    private static final String LN = System.getProperty("line.separator");
    private File dest;
    private String request;

    public ClientDemo(File dest, String request) {
        this.dest = dest;
        this.request = request;
    }

    public void run() {
        FileOutputStream fos = null;
        Socket socket = null;
        try {
            /* Connect to server, request the hosted file and save it on local machine */
            socket = new Socket("localhost", ServerDemo.DEFAULT_PORT); // Connect
            socket.getOutputStream().write((request + LN).getBytes()); // Request
            InputStream in = socket.getInputStream();
            fos = new FileOutputStream(dest);
            try {
                new BufferedCopyProgram().copy(in, fos); // Save
                System.out.println("Copying succeeded!");
            } catch (IOException e) {
                System.err.println("Copying failed");
                processIncompleteFile();
            }
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

    private void processIncompleteFile() {
        while (true) {
            System.out.print("Delete the incomplete file (y/n)? ");
            String userAnswer = new Scanner(System.in).next();
            if (userAnswer.equalsIgnoreCase("Y")) {
                dest.deleteOnExit();
                break;
            } else if (userAnswer.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Invalid answer. Type 'y' or 'n'.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        boolean runLocally = false;
        File tempFile4 = File.createTempFile("java-logo_SOCKET_", ".gif");
        String request = ProtocolDemo.FILE_REQUEST;
        if (runLocally) {
            int lastDotIndex = ProtocolDemo.GIGAFILE_PATH.lastIndexOf(".");
            tempFile4 = new File(new StringBuilder(ProtocolDemo.GIGAFILE_PATH).insert(lastDotIndex, "_COPY").toString());
            request = ProtocolDemo.FILE_REQUEST2;
        }
        new Thread(new ClientDemo(tempFile4, request)).start();
    }
}
