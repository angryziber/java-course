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
        simpleCopy(new FileReader(src), new FileWriter(dest));
    }

    @Override
    public void copy(InputStream src, OutputStream dest) throws IOException {
        simpleCopy(new InputStreamReader(src), new OutputStreamWriter(dest));
    }

    public void simpleCopy(Reader src, Writer dest) throws IOException {
        Scanner scanner = new Scanner(src).useDelimiter("\n");
        while (scanner.hasNext()) {
            dest.append(scanner.next()).append(System.getProperty("line.separator"));
        }
        dest.flush();
        dest.close();
    }
}
