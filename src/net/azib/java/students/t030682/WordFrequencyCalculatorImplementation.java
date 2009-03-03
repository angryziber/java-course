package net.azib.java.students.t030682;

import net.azib.java.lessons.collections.WordFrequencyCalculator;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculatorImplementation
 * 
 * @author aplotn
 */
public class WordFrequencyCalculatorImplementation implements WordFrequencyCalculator {

	public static void main(String[] args) {
		WordFrequencyCalculatorImplementation calc = new WordFrequencyCalculatorImplementation();
		String s1 = new String("Java is a programming language originally developed by " +
				"James Gosling at Sun Microsystems and released in 1995 as a core component " +
				"of Sun Microsystems' Java platform. The language derives much of its syntax " +
				"from C and C++ but has a simpler object model and fewer low-level facilities. " +
				"Java applications are typically compiled to bytecode that can run on any Java " +
				"virtual machine (JVM) regardless of computer architecture.The original and reference " +
				"implementation Java compilers, virtual machines, and class libraries were developed " +
				"by Sun from 1995. As of May 2007, in compliance with the specifications of the " +
				"Java Community Process, Sun made available most of their Java technologies as " +
				"free software under the GNU General Public License. Others have also developed " +
				"alternative implementations of these Sun technologies, such as the GNU Compiler " +
				"or Java and GNU Classpath.");
		Map<String, Integer> tree2 = calc.calculateFrequenciesOf(s1);
		for (Map.Entry<String, Integer> mp1 : tree2.entrySet()) {
			System.out.println(mp1.getKey() + "=" + mp1.getValue());
		}
	}

	public Map<String, Integer> calculateFrequenciesOf(String text) {
		TreeMap<String, Integer> tree1 = new TreeMap<String, Integer>();
		String[] str1 = text.split("\\s");
		for (String string : Arrays.asList(str1)) {
			String key = string;
			Integer value = 1;
			if (tree1.containsKey(string)) {
				value = tree1.get(string) + 1;
			}
			tree1.put(key, value);
		}
		return tree1;
	}

}
