package net.azib.java.students.t030629.hometasks.ht6;

import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 02.04.2008
 * <br>Time: 16:11:52
 */
public class CopyProgramDemo {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        //todo: The following 3 commented blocks (Try URL, Try URI and Try Files) work perfectly,
        //todo: so uncomment them as soon as Try Sockets is made to work correctly.
        //todo: Otherwise, temp files won't be deleted, since the Try Sockets block doesn't terminate
        //todo: by itself and has to be terminated forcedly.
//        /* ######## Try URL ######## */
//        InputStream inputStream = null;
//        FileOutputStream outputStream = null;
//        try {
//            inputStream = new URL("http://www.ee/").openStream();
//
//            File tempFile = File.createTempFile("TempWWW_EE_", ".html");
//            tempFile.deleteOnExit();
//            outputStream = new FileOutputStream(tempFile);
//
//            new BufferedCopyProgram().copy(inputStream, outputStream);
//            System.out.println("Copy from URL done.   (TempWWW_EE_****.html)");
//        } finally {
//            QuietCloser.closeQuietly(inputStream);
//            QuietCloser.closeQuietly(outputStream);
//        }
//
//        /* ######## Try URI ######## */
//        InputStream inputStream2 = null;
//        FileOutputStream outputStream2 = null;
//        URI javaLogoUri;
//        try {
//            javaLogoUri = CopyProgramDemo.class.getResource("/java-logo.gif").toURI();
//            inputStream2 = javaLogoUri.toURL().openStream();
//
//            File tempFile2 = File.createTempFile("java-logo_URI_", ".gif");
//            tempFile2.deleteOnExit();
//            outputStream2 = new FileOutputStream(tempFile2);
//
//            new BufferedCopyProgram().copy(inputStream2, outputStream2);
//            System.out.println("Copy from URI done.   (java-logo_URI_****.gif)");
//        } finally {
//            QuietCloser.closeQuietly(inputStream2);
//            QuietCloser.closeQuietly(outputStream2);
//        }
//
//        /* ######## Try Files ######## */
//        File tempFile3 = File.createTempFile("java-logo_FILE_", ".gif");
//        tempFile3.deleteOnExit();
//
//        new BufferedCopyProgram().copy(new File(javaLogoUri), tempFile3);
//        System.out.println("Copy from File done.   (java-logo_FILE_****.gif)");

        /* ######## Try Sockets ######## */
        File tempFile4 = File.createTempFile("java-logo_SOCKET_", ".gif");
        tempFile4.deleteOnExit();
        // Create Server part and start it
        ServerDemo server = ServerDemo.getInstance();
        Thread serverThread = null;
        if (server != null) {
            serverThread = new Thread(server);
            serverThread.start();
            /*  Wait for the server to start*/
            while (!serverThread.isAlive()) {
                Thread.sleep(500);
            }

            /* Create Client part and send a request to the server */
            Thread clientThread = new Thread(new ClientDemo(tempFile4));
            clientThread.start();
        }


        /* Here check for all files to be copied to the default temporary directory
         * and press ENTER to terminate the program. */
        System.out.print("Press <ENTER> to exit...");
        System.in.read();
        /* Stop server */
        if (serverThread != null) {
            serverThread.interrupt();
        }

    }

}
