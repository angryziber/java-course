package net.azib.java.students.t030629.hometasks.ht6;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;

/**
 * Class for closing {@link java.io.Closeable Closeables}
 * and {@link java.net.Socket Sockets} quietly.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 02.04.2008
 * <br>Time: 18:49:48
 */
public class QuietCloser {

    /* Forbid instantiation */
    private QuietCloser() {}

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                /* Keep silent */
            }
        }
    }

    public static void closeQuietly(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                /* Keep silent */ 
            }
        }
    }
}
