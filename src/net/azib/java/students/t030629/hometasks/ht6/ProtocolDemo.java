package net.azib.java.students.t030629.hometasks.ht6;

import java.io.InputStream;
import java.io.IOException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 04.04.2008
 * <br>Time: 12:43:58
 */
public class ProtocolDemo {
    static final String FILE_REQUEST = "GET YOUR MEGAFILE";


    public InputStream processInput(String clientInput) throws IOException {

        if (clientInput.equalsIgnoreCase(FILE_REQUEST)) {
            return ServerDemo.class.getResource("/java-logo.gif").openStream();
        } else return null;
        
    }
}
