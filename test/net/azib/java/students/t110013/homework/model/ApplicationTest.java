package net.azib.java.students.t110013.homework.model;

import net.azib.java.students.t110013.homework.readers.AthletesReaderTypes;
import net.azib.java.students.t110013.homework.writers.AthletesWriterTypes;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Vadim
 */
public class ApplicationTest {
	private Application app = new Application();
	private Athlete athlete1 = mock(Athlete.class);
	private Athlete athlete2 = mock(Athlete.class);
	@Mock
	private List<Athlete> athletes;

	@Test
	public void twoThreeOrFourArgumentAreExpected() {
		app.validateNumberOfArguments(new String[]{"a", "b"});
		app.validateNumberOfArguments(new String[]{"a", "b", "c"});
		app.validateNumberOfArguments(new String[]{"a", "b", "c", "d"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void fiveOrMoreArgumentsAreNotAllowed() {
		app.validateNumberOfArguments(new String[]{"a", "b", "c", "d", "e"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void oneArgumentIsNotAllowed() {
		app.validateNumberOfArguments(new String[]{"a"});
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidInputMethodIsNotAllowed() {
		app.validateInputMethod(new String[]{"file", "in.csv", "-xml", "out.xml"});
	}

	@Test
	public void validateInputMethod() {
		String[] args = {"-csv", "in.csv", "-xml", "out.xml"};

		assertThat(app.validateInputMethod(args), returns("-csv"));
	}

	@Test
	public void validateInputParameterWhenInputParametrizable() {
		String[] args = {"-db", "2", "-xml", "out.xml"};

		assertThat(app.validateInputParameter(args, true), returns("2"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void absenceOfInputParameterWhenInputParametrizableNotAllowed() {
		app.validateInputParameter(new String[]{"-csv", "-xml", "out.xml"}, true);
	}

	@Test
	public void validateInputParameterWhenInputNotParametrizable() {
		String[] args = {"-console", "-xml", "out.xml"};

		assertThat(app.validateInputParameter(args, false), is((String)null));
	}

	@Test(expected = IllegalArgumentException.class)
	public void presenceOfInputParameterWhenInputNotParametrizableNotAllowed() {
		app.validateInputParameter(new String[]{"-console", "in.csv", "-xml", "out.xml"}, false);
	}

	@Test
	public void validateOutputMethodWhenInputParametrizable() {
		String[] args = {"-db", "2", "-xml", "out.xml"};

		assertThat(app.validateOutputMethod(args, true), returns("-xml"));
	}

	@Test
	public void validateOutputMethodWhenInputNotParametrizable() {
		String[] args = {"-console", "-xml", "out.xml"};

		assertThat(app.validateOutputMethod(args, false), returns("-xml"));
	}

	@Test
	public void validateOutputParameterWhenInputAndOutputParametrizable() {
		String[] args = {"-csv", "in.csv", "-html", "out.html"};

		assertThat(app.validateOutputParameter(args, true, true), returns("out.html"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void absenceOfOutputParameterWhenInputAndOutputParametrizableNotAllowed() {
		app.validateOutputParameter(new String[]{"-csv", "in.csv", "-html"}, true, true);
	}

	@Test
	public void validateOutputParameterWhenOnlyInputParametrizable() {
		String[] args = {"-csv", "in.csv", "-console"};

		assertThat(app.validateOutputParameter(args, true, false), is((String)null));
	}

	@Test
	public void validateOutputParameterWhenOnlyOutputParametrizable() {
		String[] args = {"-console", "-csv", "out.csv"};

		assertThat(app.validateOutputParameter(args, false, true), returns("out.csv"));
	}

	@Test
	public void validateOutputParameterWhenInputAndOutputNotParametrizable() {
		String[] args = {"-console", "-console"};

		assertThat(app.validateOutputParameter(args, false, false), is((String)null));
	}

	@Test
	public void inputMethodWillReturnAppropriateReaderType() {
		assertThat(app.getReaderType("-csv"), is(AthletesReaderTypes.CSV));
		assertThat(app.getReaderType("-db"), is(AthletesReaderTypes.DB));
	}

	@Test(expected = IllegalArgumentException.class)
	public void unsupportedInputMethodsAreNotAllowed() {
		app.getReaderType("-gravityfield");
	}

	@Test
	public void outputMethodWillReturnAppropriateWriterType() {
		assertThat(app.getWriterType("-xml"), is(AthletesWriterTypes.XML));
		assertThat(app.getWriterType("-html"), is(AthletesWriterTypes.HTML));
	}

	@Test(expected = IllegalArgumentException.class)
	public void unsupportedOutputMethodsAreNotAllowed() {
		app.getWriterType("-torsionfield");
	}

	@Test
	public void calculateTotalScore() {
		prepareAthlete(athlete1, 12.61, 5.0, 9.22, 1.50, 60.39, 16.43, 21.60, 2.60, 35.81, 325.72);
		assertThat(app.calculateTotalScore(athlete1), is(4200));
	}

	@Test
	public void calculatePlace() {
		MockitoAnnotations.initMocks(this);

		when(athletes.indexOf(athlete1)).thenReturn(0);
		when(athletes.indexOf(athlete2)).thenReturn(1);
		when(athletes.lastIndexOf(athlete1)).thenReturn(0);
		when(athletes.lastIndexOf(athlete2)).thenReturn(3);

		assertThat(app.calculatePlace(athlete1, athletes), is("1"));
		assertThat(app.calculatePlace(athlete2, athletes), is("2-4"));
	}

	private Matcher<String> returns(String expected) {
		return is(expected);
	}

	private void prepareAthlete(Athlete athlete, double... results) {
		int i = 0;
		for (double result : results) {
			when(athlete.getPerformanceResult(i++)).thenReturn(result);
		}
	}
}
