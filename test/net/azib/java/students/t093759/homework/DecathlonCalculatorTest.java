package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.azib.java.students.t093759.homework.DecathlonCalculator.InputMethod;
import static net.azib.java.students.t093759.homework.DecathlonCalculator.OutputMethod;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dionis
 *         5/29/117:58 PM
 */
public class DecathlonCalculatorTest {
	DecathlonCalculator decathlonCalculator = new DecathlonCalculator();

	@Test
	public void badLengthOfParametersExamples() {
		ParamsParser zeroLengthParser = mock(ParamsParser.class);
		when(zeroLengthParser.getKeys()).thenReturn(Collections.<String>emptyList());
		ParamsParser oneElementParser = mock(ParamsParser.class);
		when(oneElementParser.getKeys()).thenReturn(Collections.singletonList(new String()));
		ParamsParser threeElementParser = mock(ParamsParser.class);
		List<String> threeElementList = Arrays.asList("", "", "");
		when(threeElementParser.getKeys()).thenReturn(threeElementList);
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(zeroLengthParser));
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(oneElementParser));
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(threeElementParser));
	}

	@Test
	public void helpExample() {
		String usageHelp = "usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]";
		assertTrue(new DecathlonCalculator().helpMessage().startsWith(usageHelp));
	}

	@Test
	public void supportedInputMethodCLIParamExample() {
		for (String command : new String[]{"-console", "-csv", "-db"}) {
			assertThat(InputMethod.getInstanceFor(command).createAthleteLoader(), is(instanceOf(AthletesLoader.class)));
		}
	}

	@Test(expected = RuntimeException.class)
	public void tryToUseSomeUnsupportedInputMethod() {
		assertThat(InputMethod.getInstanceFor("-pdf").createAthleteLoader(), is(instanceOf(AthletesLoader.class)));
	}


	@Test
	public void supportedOutputMethodCLIParamExample() {
		for (String command : new String[]{"-console", "-csv", "-xml", "-html"}) {
			assertThat(OutputMethod.getInstanceFor(command).createAthleteSaver(), is(instanceOf(AthletesOutput.class)));
		}
	}

	@Test(expected = RuntimeException.class)
	public void tryToUseSomeUnsupportedOutputMethod() {
		assertThat(OutputMethod.getInstanceFor("-odt").createAthleteSaver(), is(instanceOf(AthletesOutput.class)));
	}
}