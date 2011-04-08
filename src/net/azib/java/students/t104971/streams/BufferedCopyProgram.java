package net.azib.java.students.t104971.streams;

import net.azib.java.lessons.io.DataCopier;
import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * @author Jaroslav Judin
 */
public class BufferedCopyProgram implements FileCopier, DataCopier {

    @Override
    public void copy(File src, File dest) throws IOException {
        bufferedCopy(new FileInputStream(src), new FileOutputStream(dest));
    }

    @Override
    public void copy(InputStream src, OutputStream dest) throws IOException {
        bufferedCopy(src, dest);
    }

    public void bufferedCopy(InputStream src, OutputStream dest) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(src);
        BufferedOutputStream outputStream = new BufferedOutputStream(dest);

        SimpleCopyProgram.SimpleCopy(inputStream, outputStream);
    }

    private void bufferedTextCopy(Reader src, Writer dest) throws IOException {
        BufferedReader fr = new BufferedReader(src);
        BufferedWriter fw = new BufferedWriter(dest);
        String line;
        while ((line = fr.readLine()) != null) {
            fw.append(line);
            fw.newLine();
        }
        fw.flush();
        fw.close();
    }
}
