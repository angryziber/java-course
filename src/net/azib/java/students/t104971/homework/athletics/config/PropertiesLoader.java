package net.azib.java.students.t104971.homework.athletics.config;

import java.util.ResourceBundle;

/**
 * @author Jaroslav Judin
 */
public class PropertiesLoader {

    public static ResourceBundle getDbProperties() {
        return ResourceBundle.getBundle(PropertiesLoader.class.getPackage().getName() + ".db");
    }

    public static ResourceBundle getConfig() {
        return ResourceBundle.getBundle(PropertiesLoader.class.getPackage().getName() + ".config");
    }

    public static String getLog4jPath() {
        return getConfig().getString("log4j");
    }

    public static String getCSVPath() {
        return getConfig().getString("CSV_FILE");
    }

    public static String getPagePath() {
        return getConfig().getString("page_xsl");
    }

    public static String getXMLPath() {
        return getConfig().getString("out_xml");
    }
}
