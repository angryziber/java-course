package net.azib.java.students.t030629.hometasks.ht6;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;

/**
 * Server that hosts <code>java-logo.gif</code> file and sends it to the connected client
 * (instance of {@link ClientDemo})
 * in response to {@link ProtocolDemo#FILE_REQUEST}.
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
            try {
                if (threadCount < MAX_THREAD_COUNT) {
                    new Thread(new RequestHandler(serverSocket.accept())).start();
                    threadCount++;
                }
            }
            catch (IOException e) {
                System.err.println(CONNECTING_FAILED_TEXT);
            }

        }

    }

    private class RequestHandler implements Runnable {
        private static final String IO_STREAM_ERROR_TEXT = "Could not obtain I/O streams from the socket on address: ";
        private static final String REQUEST_READ_PROCESS_ERROR_TEXT = "Could not read or process request from socket InputStream on address: ";
        private static final String COPY_FAILED = "Copy failed for address: ";
        private Socket socket;

        public RequestHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            InetAddress address = socket.getInetAddress();
            address.getHostName(); address.getHostName(); // obtain all values for further use in toString()

            BufferedReader reader;
            OutputStream out;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = socket.getOutputStream();
            } catch (IOException e) {
                System.err.println(IO_STREAM_ERROR_TEXT + address);
                return;
            }

            ProtocolDemo protocol = new ProtocolDemo();
            String clientInput;
            InputStream serverOutput = null;
            try {
                clientInput = reader.readLine();
                serverOutput = protocol.processInput(clientInput);
                try {
                    new BufferedCopyProgram().copy(serverOutput, out);
                } catch (IOException e) {
                    System.err.println(COPY_FAILED + address);
                }
            } catch (IOException e) {
                System.err.println(REQUEST_READ_PROCESS_ERROR_TEXT + address);
            } finally {
                QuietCloser.closeQuietly(serverOutput);
                QuietCloser.closeQuietly(socket);
            }
        }

    }

    public static void main(String[] args) {
        ServerDemo.getInstance().run();
    }
}
