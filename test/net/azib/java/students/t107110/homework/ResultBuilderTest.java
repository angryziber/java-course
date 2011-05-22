package net.azib.java.students.t107110.homework;

import org.junit.Before;
import org.junit.Test;

import static net.azib.java.students.t107110.homework.Utils.date;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class ResultBuilderTest {
	private ResultBuilder builder;

	@Before
	public void prepare() {
		builder = new ResultBuilder();
		builder.setAthleteName("A").setBirthDay(date(1, 2, 3)).setCountry("CC");
		builder.setSprint100m(1.0).setLongJump(2.01).setShotPut(3.02).setHighJump(4.03).setSprint400m(5.04);
		builder.setHurdles110m(6.05).setDiscusThrow(7.06).setPoleVault(8.07).setJavelinThrow(9.08).setRace1500m(10.09);
	}

	@Test
	public void athlete() throws DecathlonException {
		assertThat(builder.getResult().getAthleteName(), is("A"));
	}

	@Test
	public void birthday() throws DecathlonException {
		assertThat(builder.getResult().getBirthday(), is(date(1, 2, 3)));
	}

	@Test
	public void country() throws DecathlonException {
		assertThat(builder.getResult().getCountry(), is("CC"));
	}

	@Test
	public void sprint100m() throws DecathlonException {
		assertThat(builder.getResult().getSprint100m(), is(1.0));
	}

	@Test
	public void longJump() throws DecathlonException {
		assertThat(builder.getResult().getLongJump(), is(2.01));
	}

	@Test
	public void shotPut() throws DecathlonException {
		assertThat(builder.getResult().getShotPut(), is(3.02));
	}

	@Test
	public void highJump() throws DecathlonException {
		assertThat(builder.getResult().getHighJump(), is(4.03));
	}

	@Test
	public void sprint400m() throws DecathlonException {
		assertThat(builder.getResult().getSprint400m(), is(5.04));
	}

	@Test
	public void hurdles110m() throws DecathlonException {
		assertThat(builder.getResult().getHurdles110m(), is(6.05));
	}

	@Test
	public void discusThrow() throws DecathlonException {
		assertThat(builder.getResult().getDiscusThrow(), is(7.06));
	}

	@Test
	public void poleVault() throws DecathlonException {
		assertThat(builder.getResult().getPoleVault(), is(8.07));
	}

	@Test
	public void javelinThrow() throws DecathlonException {
		assertThat(builder.getResult().getJavelinThrow(), is(9.08));
	}

	@Test
	public void race1500m() throws DecathlonException {
		assertThat(builder.getResult().getRace1500m(), is(10.09));
	}
}
