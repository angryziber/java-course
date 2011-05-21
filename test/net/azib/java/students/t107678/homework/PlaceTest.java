package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PlaceTest {

    Place placeOne = new Place(1,0);
    Place placeTwoToFour = new Place(2,2);
    Place placeTenToFifteenth = new Place(10,5);


    @Test
    public void getSimplePlace() throws Exception {

        assertEquals("1",placeOne.getFinalPlace());

    }

    @Test
    public void getComplicatedPlace() throws Exception {

        assertEquals("2-4",placeTwoToFour.getFinalPlace());
        assertEquals("10-15",placeTenToFifteenth.getFinalPlace());

    }

	@Test
	public void getIncorrectPlace() throws Exception {
		assertNotSame("2",placeTwoToFour.getFinalPlace());
	}
}
