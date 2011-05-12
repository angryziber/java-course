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

	@Before
	public void setCorrentResult() {
		name = "Siim Susi";
		birthDay = new Date();
		country = "EE";
		sprint100m = 12.61;
		longJump = 5.00;
		shotPut = 9.22;
		highJump = 1.50;
		sprint400m = 59.39;
		hurdles110m = 16.43;
		discusThrow = 21.60;
		poleVault = 2.60;
		javelinThrow = 35.81;
		race1500m = 325.72;
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
	public void failOnEmptyCountry() {
		country = " ";
		createResult();
	}

	@Test(expected = IllegalArgumentException.class)
	public void failOnIllegalCountry() {
		country = "XXX";
		createResult();
	}

	private Result createResult() {
		return new Result(name, birthDay, country, sprint100m, longJump, shotPut, highJump, sprint400m, hurdles110m,
				discusThrow, poleVault, javelinThrow, race1500m);
	}
}
