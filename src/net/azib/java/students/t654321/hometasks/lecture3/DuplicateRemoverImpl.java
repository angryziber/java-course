/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture3;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import net.azib.java.lessons.collections.DuplicateRemover;

/**
 *
 * @author Karl
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

    public String[] removeDuplicateStrings(String[] array) {
        if(array.length == 0){return null;}
        Set set = new LinkedHashSet(Arrays.asList(array));
        return (String[]) set.toArray(new String[set.size()]);
    }
}
