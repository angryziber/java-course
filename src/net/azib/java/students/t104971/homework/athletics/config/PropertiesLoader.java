package net.azib.java.students.t104971.homework.athletics.config;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author Jaroslav Judin
 */
public class PropertiesLoader {

    private static File rootDirectory = new File(".");

    public static File getCSVFile() {
        return new File(rootDirectory, System.getProperty("csv_file"));
    }

    public static String getPagePath() {
        return new File(rootDirectory, System.getProperty("page_xsl")).getAbsolutePath();
    }

    public static void setProperties() {
        Properties p = new Properties();
        try {
            p.load(PropertiesLoader.class.getResourceAsStream("config.properties"));
            p.load(PropertiesLoader.class.getResourceAsStream("db.properties"));
            p.load(PropertiesLoader.class.getResourceAsStream("log4j.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Object, Object> e : p.entrySet()) {
            System.setProperty(e.getKey().toString(), e.getValue().toString());
        }
        System.setProperty("file.encoding", "UTF-8");
    }
}
