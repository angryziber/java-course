package net.azib.java.students.t103758;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import net.azib.java.lessons.collections.DuplicateRemover;

public class DublicateRemoverImpl implements DuplicateRemover{

  /**
   * @param args
   */
  public static void main (String[] args) {
    String text[] = {"kaka", "kaka", "foo", "bar"};
    DublicateRemoverImpl foo = new DublicateRemoverImpl();
    String array[] = foo.removeDuplicateStrings(text);
      for (String word : array) {
          System.out.println(word);
        }
  }

  public String[] removeDuplicateStrings (String... array) {
    Set <String> words = new LinkedHashSet <String>(Arrays.asList(array));
    return words.toArray(new String[words.size()]);
  }
}
