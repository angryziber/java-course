package net.azib.java.students.t104971.streams;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;
import java.util.Scanner;

/**
 * @author Jaroslav Judin
 */
public class SimpleCopyProgram implements FileCopier, DataCopier {

    @Override
    public void copy(File src, File dest) throws IOException {
        SimpleCopy(new FileInputStream(src), new FileOutputStream(dest));
    }

    @Override
    public void copy(InputStream src, OutputStream dest) throws IOException {
        SimpleCopy(src, dest);
    }

    static void SimpleCopy(InputStream src, OutputStream dest) throws IOException {
        byte[] bytes = new byte[1024];
        int len;
        while ((len = src.read(bytes)) > 0) {
            dest.write(bytes, 0, len);
        }
        src.close();
        dest.close();
    }

    public void scannerCopy(Reader src, Writer dest) throws IOException {
        Scanner scanner = new Scanner(src).useDelimiter("\n");
        while (scanner.hasNext()) {
            dest.append(scanner.next()).append(System.getProperty("line.separator"));
        }
        dest.flush();
        dest.close();
    }
}
