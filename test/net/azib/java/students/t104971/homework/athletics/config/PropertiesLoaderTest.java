package net.azib.java.students.t104971.homework.athletics.config;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class PropertiesLoaderTest {

    @Test
    public void testSetProperties() throws Exception {
        int startPropertiesSize = System.getProperties().size();
        PropertiesLoader.setProperties();
        int finalPropertiesSize = System.getProperties().size();
        assertTrue(finalPropertiesSize - startPropertiesSize > 0);
    }
}
