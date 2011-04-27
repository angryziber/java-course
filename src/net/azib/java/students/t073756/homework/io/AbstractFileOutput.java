package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.DecathlonException;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class AbstractFileOutput implements OutputProvider {
    private File outputFile;

    protected AbstractFileOutput(File outputFile) {
        this.outputFile = outputFile;
    }

    void writeToFile(String content) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(outputFile);
            IOUtils.write(content, out, "UTF-8");
        } catch (FileNotFoundException e) {
            throw new DecathlonException("no such file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new DecathlonException("unable write to file: " + outputFile.getAbsolutePath());
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    public File getOutputFile() {
        return outputFile;
    }
}
