/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture5;

import java.util.Arrays;
import java.util.Collection;
import net.azib.java.lessons.basic.Todo;
import net.azib.java.lessons.collections.DuplicateRemover;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;


/**
 *
 * @author Karl
 */

@Todo
// See that, why it isn't working!
public class UniqueWordExttractorTest {

    @Test
    public void happyPath() throws Exception {
        String inputText = "hello cruel world which is very cruel";

        final String[] inputResult = inputText.split(" ");
        final String[] removerResult = {"hello", "cruel", "world", "which", "is", "very"};

        DuplicateRemover mockRemover = createMock(DuplicateRemover.class);
        expect(mockRemover.removeDuplicateStrings(inputResult)).andReturn(removerResult); //recording
        replay(mockRemover); //replaying


        UniqueWordExttractor uwe = new UniqueWordExttractor(inputText,mockRemover);
        Collection <String> expected = Arrays.asList(removerResult);

        assertEquals(expected, uwe.getUniqueWords());
        //assertEquals(1,1);
        verify(mockRemover);
    }

//  manual implementation
//        DuplicateRemover fakeRemover = new DuplicateRemover() {
//
//            public String[] removeDuplicateStrings(String[] array) {
//                assertArrayEquals();
//                return removerResult;
//            }
//        };

}