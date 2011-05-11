package net.azib.java.students.t104971.homework.athletics.config;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class PropertiesLoaderTest {

    @Before
    public void setUp() throws Exception {
        PropertiesLoader.setProperties();
    }

    @Test
    public void testGetCSVFile() throws Exception {
      assertTrue(PropertiesLoader.getCSVFile().getAbsolutePath().endsWith("data-in.csv"));
    }

    @Test
    public void testGetPagePath() throws Exception {
      assertTrue(PropertiesLoader.getPagePath().endsWith("page.xsl"));
    }
}
