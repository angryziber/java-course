package net.azib.java.students.t103640;

import net.azib.java.students.t103640.PlayingWithAnimals.Pet;
import org.junit.Test;

import static junit.framework.Assert.*;

public class PetTest {

    @Test
    public void isPetNameable(){
         Pet gamma =  new Pet(32, "Gamma"){};
        assertEquals(gamma.getName(), "Gamma");
    }


}
