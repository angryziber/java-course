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
        bufferedCopy(new FileReader(src), new FileWriter(dest));
    }

    @Override
    public void copy(InputStream src, OutputStream dest) throws IOException {
        bufferedCopy(new InputStreamReader(src), new OutputStreamWriter(dest));
    }

    public void bufferedCopy(Reader src, Writer dest) throws IOException {
	    // todo: only text is supported
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
