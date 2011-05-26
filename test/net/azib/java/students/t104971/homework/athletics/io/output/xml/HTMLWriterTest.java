package net.azib.java.students.t104971.homework.athletics.io.output.xml;

import net.azib.java.students.t104971.homework.athletics.io.TestDB;
import net.azib.java.students.t104971.homework.athletics.io.output.CommonOutputTest;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class HTMLWriterTest extends CommonOutputTest {

    @Test
    public void testWrite() throws Exception {
        HTMLWriter htmlWriter = new HTMLWriter(TestDB.getTestAthletes());

        String content = readCreatedFile(htmlWriter.write("tmpHtmlFile.html"));

        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Decathlon Results</h2>\n" +
                "<table border=\"1\">\n" +
                "<tr bgcolor=\"#FFE87C\">\n" +
                "<th>Place</th>\n" +
                "<th>Name</th>\n" +
                "<th>Total Score</th>\n" +
                "<th>RACE_100_METERS</th>\n" +
                "<th>LONG_JUMP</th>\n" +
                "<th>SHOT_PUT</th>\n" +
                "<th>HIGH_JUMP</th>\n" +
                "<th>RACE_400_METERS</th>\n" +
                "<th>RACE_110_METERS_HURDLES</th>\n" +
                "<th>DISCUS_THROW</th>\n" +
                "<th>POLE_VAULT</th>\n" +
                "<th>JAVELIN_THROW</th>\n" +
                "<th>RACE_1500_METERS</th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>1</td>\n" +
                "<td>Jaak Tepandi</td>\n" +
                "<td>0</td>\n" +
                "<td>5.0s</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0s</td>\n" +
                "<td>5.0s</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0m</td>\n" +
                "<td>5.0s</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>\n", content);
    }
}
