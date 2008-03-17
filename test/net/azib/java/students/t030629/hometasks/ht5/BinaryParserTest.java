package net.azib.java.students.t030629.hometasks.ht5;

import org.junit.Before;
import org.junit.Test;
import static org.easymock.EasyMock.*;

import java.io.InputStream;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 17.03.2008
 * <br>Time: 12:12:04
 */
public class BinaryParserTest {

    private BinaryParser binaryParser;

    @Before
    public void initBinaryParser(){
        binaryParser = new BinaryParser();
    }

    @Test
    public void testParser(){
        
        binaryParser.listen();
    }

    @Test
    public void testRead(){
        InputStream mockSystemIn = createMock(InputStream.class);
//        expect(mockSystemIn).andReturn();

        replay(mockSystemIn);

//        new BinaryParser(mockSystemIn, );

    }

}
