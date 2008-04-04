package net.azib.java.students.t030629.hometasks.ht6;

import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 04.04.2008
 * <br>Time: 12:43:58
 */
public class ProtocolDemo {
    static final String FILE_REQUEST = "GET YOUR MEGAFILE";
    static final String FILE_REQUEST2 = "GET YOUR GIGAFILE";
    /* 45MB file, to test what happens on the Client side when Server goes down */
    static final String GIGAFILE_PATH = "D:\\TEMPORARY\\BlueCanary_1988_.rar";


    public InputStream processInput(String clientInput) throws IOException {

        if (clientInput.equalsIgnoreCase(FILE_REQUEST)) {

            return ProtocolDemo.class.getResource("/java-logo.gif").openStream();

        } else if (clientInput.equalsIgnoreCase(FILE_REQUEST2)) {

            return new FileInputStream(new File(GIGAFILE_PATH));

        } else return null;
        
    }
}
