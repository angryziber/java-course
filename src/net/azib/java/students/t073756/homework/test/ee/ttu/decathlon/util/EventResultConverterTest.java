package ee.ttu.decathlon.util;

import ee.ttu.decathlon.DecathlonException;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * User: anton
 * Date: 4/2/11
 * Time: 11:20 AM
 */
public class EventResultConverterTest {

    @Test
    public void shouldSplitResultToTokens() throws Exception {
        List<Integer> result = EventResultConverter.splitResult("5.09");

        assertEquals(2, result.size());
        assertEquals(5, result.get(0).intValue());
        assertEquals(9, result.get(1).intValue());

        result = EventResultConverter.splitResult("5:10.99");

        assertEquals(3, result.size());
        assertEquals(5, result.get(0).intValue());
        assertEquals(10, result.get(1).intValue());
        assertEquals(99, result.get(2).intValue());
    }

    @Test
    public void shouldConvertJumpResult() throws Exception {
        assertEquals(202.0, EventResultConverter.convertJumpingResults("2.02"));
        assertEquals(222.0, EventResultConverter.convertJumpingResults("2.22"));
        assertEquals(220.0, EventResultConverter.convertJumpingResults("2.2"));
    }

    @Test
    public void shouldConvertRunningResults() throws Exception {
        assertEquals(9.27 ,EventResultConverter.convertRunningResults("9.27"));
        assertEquals(9.27 ,EventResultConverter.convertRunningResults("09.27"));
        assertEquals(599.27 ,EventResultConverter.convertRunningResults("9:59.27"));
        assertEquals(599.27 ,EventResultConverter.convertRunningResults("09:59.27"));

        try {
            EventResultConverter.convertRunningResults("009:59.27");
            fail();
        } catch (DecathlonException e) {
            assertEquals("Wrong format for running event, input string: 009:59.27", e.getMessage());
        }
    }
}
