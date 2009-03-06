/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Karl
 */
public class PropertiesDemo {

    public static void main(String... args) throws IOException {
        Properties properties = System.getProperties();
        for (Object name : properties.keySet()) {
            System.out.println(name + "=" + properties.getProperty((String) name));
        }
        String propsFile = "karl.properties";
        properties.store(new FileOutputStream((new File(propsFile))), "System props");

    }
}
