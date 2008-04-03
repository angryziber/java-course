package net.azib.java.students.t030629.hometasks.ht6;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

/**
 * Server that hosts <code>java-logo.gif</code> file and sends it to the connected client
 * (instance of {@link net.azib.java.students.t030629.hometasks.ht6.ClientDemo})
 * in response to {@link net.azib.java.students.t030629.hometasks.ht6.ClientDemo#FILE_REQUEST}.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 02.04.2008
 * <br>Time: 17:24:41
 */

public class ServerDemo implements Runnable {
    static final int DEFAULT_PORT = 9090;
    private static final byte MAX_THREAD_COUNT = 100;
    private static final String CONNECTING_FAILED_TEXT = "Could not initiate a connection";

    private ServerSocket serverSocket;

    private static byte threadCount = 0;
    private static ServerDemo ourInstance = new ServerDemo();

    public static ServerDemo getInstance() {
        return ourInstance;
    }

    private ServerDemo() {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            serverSocket = null;
        }
    }

    public void run() {

        while (!Thread.interrupted()) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                if (threadCount < MAX_THREAD_COUNT) {
                    new Thread(new RequestHandler(socket)).start();
                    threadCount++;
                }
            }
            catch (IOException e) {
                System.err.println(CONNECTING_FAILED_TEXT);
            }

        }

    }

    private class RequestHandler implements Runnable {
        private static final String OUTPUT_STREAM_ERROR_TEXT = "Could not obtain an OutputStream from the socket on address: ";
        private static final String INPUT_STREAM_ERROR_TEXT = "Could not obtain an InputStream from the socket on address: ";
        private static final String REQUEST_PROCESSING_ERROR_TEXT = "Could not read request from socket InputStream on address: ";
        private static final String COPY_FAILED = "Copy failed for address: ";
        private Socket socket;

        public RequestHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            InetAddress address = socket.getInetAddress();
            address.getHostName(); address.getHostName(); // obtain all values for further use in toString()

            BufferedReader reader;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                System.err.println(INPUT_STREAM_ERROR_TEXT + address);
                return;
            }
            try {
                if (reader.readLine().equalsIgnoreCase(ClientDemo.FILE_REQUEST)) {
                    OutputStream out;
                    InputStream in = null;
                    try {
                        try {
                            out = socket.getOutputStream();
                        } catch (IOException e) {
                            System.err.println(OUTPUT_STREAM_ERROR_TEXT + address);
                            return;
                        }

                        try {
                            in = ServerDemo.class.getResource("/java-logo.gif").openStream();
                            new BufferedCopyProgram().copy(in, out);
                        } catch (IOException e) {
                            System.err.println(COPY_FAILED + address);
                        }
                    } finally {
                        QuietCloser.closeQuietly(in);
                        QuietCloser.closeQuietly(socket);
                    }
                } 
            } catch (IOException e) {
                System.err.println(REQUEST_PROCESSING_ERROR_TEXT + address);
            }
        }

    }

    public static void main(String[] args) {
        ServerDemo.getInstance().run();
    }
}
