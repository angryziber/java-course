package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.Map;

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
		Map zeroLengthMap = mock(Map.class);
		when(zeroLengthMap.size()).thenReturn(0);
		Map oneElementMap = mock(Map.class);
		when(oneElementMap.size()).thenReturn(1);
		Map threeElementMap = mock(Map.class);
		when(threeElementMap.size()).thenReturn(3);
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(zeroLengthMap));
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(oneElementMap));
		assertTrue(decathlonCalculator.notEnoughOrTooMuchParameters(threeElementMap));
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
		for (String command : new String[]{"-conole", "-csv", "-xml", "-html"}) {
			assertThat(OutputMethod.getInstanceFor(command).createAthleteSaver(), is(instanceOf(AthletesOutput.class)));
		}
	}

	@Test(expected = RuntimeException.class)
	public void tryToUseSomeUnsupportedOutputMethod() {
		assertThat(OutputMethod.getInstanceFor("-odt").createAthleteSaver(), is(instanceOf(AthletesOutput.class)));
	}
}