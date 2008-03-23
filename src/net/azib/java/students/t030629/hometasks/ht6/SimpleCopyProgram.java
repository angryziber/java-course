package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 23.03.2008
 * <br>Time: 22:40:12
 */
public class SimpleCopyProgram implements FileCopier {

    public void copy(File src, File dest) throws IOException {
        /* Validate src and dest files */
        if (src == null || dest == null)
            throw new NullPointerException(NullPointerException.class.getSimpleName() + " for src or dest file");
        if (!src.exists()) throw new FileNotFoundException("src file is not found");

        /* Copy files */
//        InputStreamReader reader = new InputStreamReader(new FileInputStream(src), "UTF-8");
//        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dest), "UTF-8");
        FileReader reader = new FileReader(src);
        FileWriter writer = new FileWriter(dest);

        int aChar;
        while ((aChar = reader.read()) != -1) {
            writer.write(aChar);
        }

        reader.close();
        writer.close();
    }

}
