package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class ResultTest {
	private String name;
	private Date birthDay;
	private String country;
	private double sprint100m;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double sprint400m;
	private double hurdles110m;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race1500m;
	private int points;

	@Before
	public void prepare() {
		name = "Some Athlete";
		birthDay = new Date();
		country = "EU";
		sprint100m = 10.395;
		longJump = 7.76;
		shotPut = 18.4;
		highJump = 2.20;
		sprint400m = 46.17;
		hurdles110m = 13.8;
		discusThrow = 56.17;
		poleVault = 5.28;
		javelinThrow = 77.19;
		race1500m = 233.79;
		points = 9990;
	}

	@Test
	public void correctResult() throws DecathlonException {
		createResult();
	}

	@Test(expected = DecathlonException.class)
	public void failOnEmptyName() throws DecathlonException {
		name = " ";
		createResult();
	}

	@Test
	public void nameIsNormalized() throws DecathlonException {
		name = " Name  Surname  ";
		final Result result = createResult();
		assertThat(result.getAthleteName(), is("Name Surname"));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoBirthday() throws DecathlonException {
		birthDay = null;
		createResult();
	}

	@Test
	public void birthdayIsNotChanged() throws DecathlonException {
		birthDay = new Date();
		final Result result = createResult();
		assertThat(result.getBirthday(), is(birthDay));
	}

	@Test(expected = DecathlonException.class)
	public void failOnEmptyCountry() throws DecathlonException {
		country = " ";
		createResult();
	}

	@Test(expected = DecathlonException.class)
	public void failOnIllegalCountry() throws DecathlonException {
		country = "XXX";
		createResult();
	}

	@Test
	public void countryIsNormalized() throws DecathlonException {
		country = " eE  ";
		final Result result = createResult();
		assertThat(result.getCountry(), is("EE"));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoSprint100mResult() throws DecathlonException {
		sprint100m = 0.0;
		createResult();
	}

	@Test
	public void sprint100mResultIsNotChanged() throws DecathlonException {
		sprint100m = 3.3;
		final Result result = createResult();
		assertThat(result.getSprint100m(), is(sprint100m));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoLongJumpResult() throws DecathlonException {
		longJump = 0.0;
		createResult();
	}

	@Test
	public void longJumpResultIsNotChanged() throws DecathlonException {
		longJump = 3.3;
		final Result result = createResult();
		assertThat(result.getLongJump(), is(longJump));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoShotPutResult() throws DecathlonException {
		shotPut = 0.0;
		createResult();
	}

	@Test
	public void shotPutResultIsNotChanged() throws DecathlonException {
		shotPut = 3.3;
		final Result result = createResult();
		assertThat(result.getShotPut(), is(shotPut));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoHighJumpResult() throws DecathlonException {
		highJump = 0.0;
		createResult();
	}

	@Test
	public void highJumpResultIsNotChanged() throws DecathlonException {
		highJump = 3.3;
		final Result result = createResult();
		assertThat(result.getHighJump(), is(highJump));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoSprint400mResult() throws DecathlonException {
		sprint400m = 0.0;
		createResult();
	}

	@Test
	public void sprint400mResultIsNotChanged() throws DecathlonException {
		sprint400m = 3.3;
		final Result result = createResult();
		assertThat(result.getSprint400m(), is(sprint400m));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoHurdles110mResult() throws DecathlonException {
		hurdles110m = 0.0;
		createResult();
	}

	@Test
	public void hurdles110mResultIsNotChanged() throws DecathlonException {
		hurdles110m = 3.3;
		final Result result = createResult();
		assertThat(result.getHurdles110m(), is(hurdles110m));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoDiscusThrowResult() throws DecathlonException {
		discusThrow = 0.0;
		createResult();
	}

	@Test
	public void discusThrowResultIsNotChanged() throws DecathlonException {
		discusThrow = 3.3;
		final Result result = createResult();
		assertThat(result.getDiscusThrow(), is(discusThrow));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoPoleVaultResult() throws DecathlonException {
		poleVault = 0.0;
		createResult();
	}

	@Test
	public void poleVaultResultIsNotChanged() throws DecathlonException {
		poleVault = 3.3;
		final Result result = createResult();
		assertThat(result.getPoleVault(), is(poleVault));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoJavelinThrowResult() throws DecathlonException {
		javelinThrow = 0.0;
		createResult();
	}

	@Test
	public void javelinThrowResultIsNotChanged() throws DecathlonException {
		javelinThrow = 3.3;
		final Result result = createResult();
		assertThat(result.getJavelinThrow(), is(javelinThrow));
	}

	@Test(expected = DecathlonException.class)
	public void failOnNoRace1500mResult() throws DecathlonException {
		race1500m = 0.0;
		createResult();
	}

	@Test
	public void race1500mResultIsNotChanged() throws DecathlonException {
		race1500m = 3.3;
		final Result result = createResult();
		assertThat(result.getRace1500m(), is(race1500m));
	}

	@Test
	public void pointsCalculation() throws DecathlonException {
		final Result result = createResult();
		assertThat(result.getPoints(), is(points));
	}

	@Test
	public void equalResults() throws DecathlonException {
		final Result result = createResult();
		final Result sameResult = createResult();
		assertThat(result.compareTo(sameResult), is(0));
	}

	@Test
	public void compareOnPoints() throws DecathlonException {
		final Result result = createResult();
		sprint100m += 1;
		final Result smallerResult = createResult();

		final List<Result> list = asList(smallerResult, result);
		Collections.sort(list);
		assertThat(list, is(asList(result, smallerResult)));
	}

	@Test
	public void equalPointsCompareOnAthleteNames() throws DecathlonException {
		final Result result = createResult();
		name += " Jr.";
		final Result biggerResult = createResult();

		final List<Result> list = asList(biggerResult, result);
		Collections.sort(list);
		assertThat(list, is(asList(result, biggerResult)));
	}

	private Result createResult() throws DecathlonException {
		return new Result(name, birthDay, country, sprint100m, longJump, shotPut, highJump, sprint400m,
				hurdles110m, discusThrow, poleVault, javelinThrow, race1500m);
	}
}
