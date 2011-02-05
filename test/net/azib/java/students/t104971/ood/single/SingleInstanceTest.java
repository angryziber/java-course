package net.azib.java.students.t104971.ood.single;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class SingleInstanceTest {

    @Test
    public void testToString() throws Exception {
        SingleInstance instance = SingleInstance.getInstance();
        SingleInstance instance2 = SingleInstance.getInstance();
        assertEquals(instance, instance2);
        assertEquals(instance.hashCode(), instance2.hashCode());
    }
}
