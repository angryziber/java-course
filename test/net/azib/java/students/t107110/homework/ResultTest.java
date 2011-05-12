package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

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
	public void setCorrentResult() {
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
	public void correctResult() {
		createResult();
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnEmptyName() {
		name = " ";
		createResult();
	}

	@Test
	public void nameIsNormalized() {
		name = " Name  Surname  ";
		final Result result = createResult();
		assertThat(result.getName(), is("Name Surname"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoBirthday() {
		birthDay = null;
		createResult();
	}

	@Test
	public void nameIsUnmodified() {
		birthDay = new Date();
		final Result result = createResult();
		assertThat(result.getBirthDay(), is(birthDay));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnEmptyCountry() {
		country = " ";
		createResult();
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnIllegalCountry() {
		country = "XXX";
		createResult();
	}

	@Test
	public void countryIsNormalized() {
		country = " eE  ";
		final Result result = createResult();
		assertThat(result.getCountry(), is("EE"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoSprint100mResult() {
		sprint100m = 0.0;
		createResult();
	}

	@Test
	public void sprint100mResultIsUnmodified() {
		sprint100m = 3.3;
		final Result result = createResult();
		assertThat(result.getSprint100m(), is(sprint100m));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoLongJumpResult() {
		longJump = 0.0;
		createResult();
	}

	@Test
	public void longJumpResultIsUnmodified() {
		longJump = 3.3;
		final Result result = createResult();
		assertThat(result.getLongJump(), is(longJump));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoShotPutResult() {
		shotPut = 0.0;
		createResult();
	}

	@Test
	public void shotPutResultIsUnmodified() {
		shotPut = 3.3;
		final Result result = createResult();
		assertThat(result.getShotPut(), is(shotPut));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoHighJumpResult() {
		highJump = 0.0;
		createResult();
	}

	@Test
	public void highJumpResultIsUnmodified() {
		highJump = 3.3;
		final Result result = createResult();
		assertThat(result.getHighJump(), is(highJump));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoSprint400mResult() {
		sprint400m = 0.0;
		createResult();
	}

	@Test
	public void sprint400mResultIsUnmodified() {
		sprint400m = 3.3;
		final Result result = createResult();
		assertThat(result.getSprint400m(), is(sprint400m));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoHurdles110mResult() {
		hurdles110m = 0.0;
		createResult();
	}

	@Test
	public void hurdles110mResultIsUnmodified() {
		hurdles110m = 3.3;
		final Result result = createResult();
		assertThat(result.getHurdles110m(), is(hurdles110m));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoDiscusThrowResult() {
		discusThrow = 0.0;
		createResult();
	}

	@Test
	public void discusThrowResultIsUnmodified() {
		discusThrow = 3.3;
		final Result result = createResult();
		assertThat(result.getDiscusThrow(), is(discusThrow));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoPoleVaultResult() {
		poleVault = 0.0;
		createResult();
	}

	@Test
	public void poleVaultResultIsUnmodified() {
		poleVault = 3.3;
		final Result result = createResult();
		assertThat(result.getPoleVault(), is(poleVault));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoJavelinThrowResult() {
		javelinThrow = 0.0;
		createResult();
	}

	@Test
	public void javelinThrowResultIsUnmodified() {
		javelinThrow = 3.3;
		final Result result = createResult();
		assertThat(result.getJavelinThrow(), is(javelinThrow));
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnNoRace1500mResult() {
		race1500m = 0.0;
		createResult();
	}

	@Test
	public void race1500mResultIsUnmodified() {
		race1500m = 3.3;
		final Result result = createResult();
		assertThat(result.getRace1500m(), is(race1500m));
	}

	@Test
	public void pointsCalculation() {
		final Result result = createResult();
		assertThat(result.getPoints(), is(points));
	}

	private Result createResult() {
		return new Result(name, birthDay, country, sprint100m, longJump, shotPut, highJump, sprint400m, hurdles110m,
				discusThrow, poleVault, javelinThrow, race1500m);
	}
}
