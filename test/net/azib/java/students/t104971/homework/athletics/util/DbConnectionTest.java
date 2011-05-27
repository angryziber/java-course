package net.azib.java.students.t104971.homework.athletics.util;

import org.junit.Test;

import java.sql.Connection;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * @author Jaroslav Judin
 */
public class DbConnectionTest {
    @Test
    public void testConnect() throws Exception {
        System.setProperty("url", "jdbc:hsqldb:mem:DemoDB");
        System.setProperty("usr", "sa");
        System.setProperty("pwd", "");

        DbConnection dbConnection = new DbConnection();
        Connection c = dbConnection.connect();
        assertNotNull(c);
        assertFalse(c.isClosed());
        dbConnection.close();
        assertTrue(c.isClosed());
    }
}
