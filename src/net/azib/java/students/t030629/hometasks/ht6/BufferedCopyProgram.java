package net.azib.java.students.t030629.hometasks.ht6;

import net.azib.java.lessons.io.FileCopier;

import java.io.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 24.03.2008
 * <br>Time: 0:25:32
 */
public class BufferedCopyProgram implements FileCopier {

    public void copy(File src, File dest) throws IOException {
        /* Validate src and dest files */
        if (src == null || dest == null)
            throw new NullPointerException(NullPointerException.class.getSimpleName() + " for src or dest file");
        if (!src.exists()) throw new FileNotFoundException("src file is not found");

        /* Copy files */
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "UTF-8"));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"));
        BufferedReader reader = new BufferedReader(new FileReader(src));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dest));

        int aChar;
        while ((aChar = reader.read()) != -1) {
            writer.write(aChar);
        }

        reader.close();
        writer.close();

    }

}
