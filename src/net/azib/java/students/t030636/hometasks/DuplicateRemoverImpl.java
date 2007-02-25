package net.azib.java.students.t030636.hometasks;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemoverImpl implements DuplicateRemover {

	@Override
	public String[] removeDuplicateStrings(String[] string) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(string));
		return set.toArray(new String[set.size()]);
	}
	public static void main(String[] args) {
		String[] strings = {"ufo", "mina", "ufo", "teie", "tore", "ufo", "teie"};
		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		
		for(String string : remover.removeDuplicateStrings(strings))
			System.out.println(string);
		
		}
}
