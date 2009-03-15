/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.lectures.lecture5;

import java.util.Arrays;
import java.util.Collection;
import net.azib.java.lessons.collections.DuplicateRemover;
import net.azib.java.students.t654321.hometasks.lecture3.DuplicateRemoverImpl;

/**
 *
 * @author Karl
 */
public class UniqueWordExttractor {

    private final String text;
    private DuplicateRemover remover;

    public UniqueWordExttractor(String text) {
        this.text = text;
    }

    UniqueWordExttractor(String text, DuplicateRemover removerImpl) {
        this(text);
        this.remover = removerImpl;
    }

    Collection<String> getUniqueWords() {
        String[] duplicateWords = text.split("\\s");
        String[] uniqueWords = remover.removeDuplicateStrings(duplicateWords);
        return Arrays.asList(uniqueWords);
    }
}
