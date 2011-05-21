package net.azib.java.students.t107110.homework;

import java.util.Date;

public class ResultBuilder {
	private String athleteName;
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

	public ResultBuilder setAthleteName(String name) {
		this.athleteName = name;
		return this;
	}

	public ResultBuilder setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public ResultBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public ResultBuilder setSprint100m(double sprint100m) {
		this.sprint100m = sprint100m;
		return this;
	}

	public ResultBuilder setLongJump(double longJump) {
		this.longJump = longJump;
		return this;
	}

	public ResultBuilder setShotPut(double shotPut) {
		this.shotPut = shotPut;
		return this;
	}

	public ResultBuilder setHighJump(double highJump) {
		this.highJump = highJump;
		return this;
	}

	public ResultBuilder setSprint400m(double sprint400m) {
		this.sprint400m = sprint400m;
		return this;
	}

	public ResultBuilder setHurdles110m(double hurdles110m) {
		this.hurdles110m = hurdles110m;
		return this;
	}

	public ResultBuilder setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
		return this;
	}

	public ResultBuilder setPoleVault(double poleVault) {
		this.poleVault = poleVault;
		return this;
	}

	public ResultBuilder setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
		return this;
	}

	public ResultBuilder setRace1500m(double race1500m) {
		this.race1500m = race1500m;
		return this;
	}

	public Result getResult() throws DecathlonException {
		return new Result(athleteName, birthDay, country, sprint100m, longJump, shotPut, highJump, sprint400m, hurdles110m,
				discusThrow, poleVault, javelinThrow, race1500m);
	}
}