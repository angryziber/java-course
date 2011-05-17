package net.azib.java.students.t103784.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 14.05.11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class Input {

	List<Athlete> contestants = new ArrayList<Athlete>();
	SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
	int lineNumber = 0, tokenNumber = 0;

	public Input() {




	}

	public void addAthlete(Athlete athlete) {
		contestants.add(athlete);
	}

	//WTF?
	/*public static enum Field {
		NAME {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkName(line)) {
					out.println("\nNames and surnames must start with capital letter.\n"
							+ "Charecters ' and - are allowed.\n"
							+ "Please enter new Firstname and Surname again.\n");
					return true;
				} else {
					friend.setName(line);
				}
				return false;
			}
		},
		BIRTHDAY {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				try {
					friend.setBirthday(DATE_FORMAT.parse(line));
				} catch (ParseException e) {
					out.println("\nFormat " + DATE_FORMAT.toPattern() + " is allowed.\n"
							+ "Please enter new Birthday.\n");
					return true;
				}
				return false;
			}
		},
		EMAIL {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkMail(line)) {
					out
							.println("\nFormat name@hostname.domain is allowed.\n"
									+ "Please enter new email address.\n");
					return true;
				} else {
					friend.setEmail(line);
				}
				return false;
			}
		},
		PHONE {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkNumber(line)) {
					out
							.println("\nOnly digits and (+xxx) country code is allowed.\n"
									+ "Please enter new phone number.\n");
					return true;
				} else {
					friend.setPhoneNmber(line);
				}
				return false;
			}
		},
		FACEBOOK {
			@Override
			public boolean parseAndStore(String line, Friend friend) {
				if (!checkFacebook(line)) {
					out
							.println("\nOnly digits and \".\" is allowed\n"
									+ "Please enter new facebook username(?).\n");
					return true;
				} else {
					friend.setFacebook(line);
				}
				return false;
			}
		};*/

	public Athlete scanAthlete(Athlete athlete, BufferedReader reader) throws IOException {

		int i = 0;

		/*try	{
			String filename = "J:\\Projects\\src\\net\\azib\\java\\students\\t103784\\homework\\sample.csv";
			BufferedReader reader2 = new BufferedReader(new FileReader(filename));
			String line;
			StringTokenizer tokenizer;

			while((line = reader2.readLine()) != null) {

				tokenizer = new StringTokenizer(line, ",");
				System.out.println("Hur");
				while(tokenizer.hasMoreTokens()) {
					System.out.println("Dur");
					athlete.name = tokenizer.nextToken();
					tokenNumber++;
					athlete.birthDate = tokenizer.nextToken();
					tokenNumber++;
					athlete.country = tokenizer.nextToken();
					tokenNumber++;
					for (int c = 0; c < 10; c++) {
						if (c == 4 || c == 9) {
							//System.out.println(tokenizer.nextToken() + " OMFG ");
							athlete.performance[c] = checkMinSec(tokenizer.nextToken());
							System.out.println(athlete.performance[c] + "TRA");


							tokenNumber++;
						}
						else {
							athlete.performance[c] = Double.parseDouble(tokenizer.nextToken());
							System.out.println(athlete.performance[c] + "TRAkylll");
							tokenNumber++;
						}
						System.out.println("\n"+c+"\n"+tokenNumber);
					}
					tokenNumber = 0;



				}
				lineNumber++;
				//tokenNumber = 0;

		}


		}
		catch(Exception e) {
			System.out.println("Exception while reading csv file: " + e);
		}*/

		while (athlete.getName() == null) {
            System.out.print("Full name: ");
			//reader.r
            athlete.setName(checkName(reader.readLine()));
        }

        while (athlete.getBirthDate() == null) {
            System.out.print("Date of Birth " + "(" + format.toPattern() + "): ");
		    athlete.setBirthDate(checkDate(reader.readLine()));
        }

        while (athlete.getCountry() == null) {
            System.out.print("Country: ");
            athlete.setCountry(checkCountry(reader.readLine()));
        }

		while (athlete.getHundredMeters() == null) {
            System.out.print("100m: ");
            try {
				athlete.setHundredMeters(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getHundredMeters();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setHundredMeters(null);
			}
		}

		while (athlete.getLongJump() == null) {
            System.out.print("Long jump: ");
            try {
				athlete.setLongJump(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getLongJump();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setLongJump(null);
			}
        }

		while (athlete.getShotPut() == null) {
            System.out.print("Shot put: ");
            try {
				athlete.setShotPut(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getShotPut();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setShotPut(null);
			}
        }

		while (athlete.getHighJump() == null) {
            System.out.print("High Jump: ");
            try {
				athlete.setHighJump(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getHighJump();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setHighJump(null);
			}
        }

		while (athlete.getFourHundredMeters() == null) {
            System.out.print("400m: ");
            try {
				athlete.setFourHundredMeters(checkMinSec(reader.readLine()));
	            athlete.performance[i] = athlete.getFourHundredMeters();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setFourHundredMeters(null);
			}
        }

		while (athlete.getHurdles() == null) {
            System.out.print("110m hurdles: ");
            try {
				athlete.setHurdles(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getHurdles();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setHurdles(null);
			}
        }

		while (athlete.getDiscus() == null) {
            System.out.print("Discus throw: ");
            try {
				athlete.setDiscus(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getDiscus();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setDiscus(null);
			}
        }

		while (athlete.getPoleVault() == null) {
            System.out.print("Pole vault: ");
            try {
				athlete.setPoleVault(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getPoleVault();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setPoleVault(null);
			}
        }

		while (athlete.getJavelin() == null) {
            System.out.print("Javelin throw: ");
            try {
				athlete.setJavelin(checkMetersSeconds(Double.valueOf(reader.readLine())));
	            athlete.performance[i] = athlete.getJavelin();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setJavelin(null);
			}
        }

		while (athlete.getRace() == null) {
            System.out.print("1500m race: ");
            try {
				athlete.setRace(checkMinSec(reader.readLine()));
	            athlete.performance[i] = athlete.getRace();
	            i++;
			} catch (NumberFormatException e) {
				athlete.setRace(null);
			}
        }

		System.out.println("\n" + athlete.name + "\n" + athlete.birthDate + "\n" + athlete.country + "\n" + athlete.hundredMeters + "\n" + athlete.longJump + "\n" + athlete.shotPut + "\n" + athlete.highJump + "\n" + athlete.fourHundredMeters + "\n" + athlete.hurdles + "\n" + athlete.discus + "\n" + athlete.poleVault + "\n" + athlete.javelin + "\n" + athlete.race);
		return athlete;
	}

	public String checkName(String name) {
		if (name.matches("[A-Z][a-z]+(\\s[A-Z]\\.)*\\s[A-Z][a-z]+"))

			return name;
		else
			return null;
	}

	public String checkDate(String birthDate) {
		if (birthDate.matches("^([1-9]|0[1-9]|[12][0-9]|3[01])[.]?([1-9]|[0][1-9]|[1][1-2])[. ]?(18|19|20)\\d{2}$"))
			return birthDate;
		else
			System.out.println("toString");
			return null;
	}

	public String checkCountry(String country) {
		if (country.matches("[A-Z]{2,2}"))
			return country;
		else
			return null;
	}

	public Double checkMetersSeconds(Double meters) {
		if (meters.isNaN())
			return null;
		else
			return meters;
	}

    public Double checkMinSec(String time) {
	    String[] timeSplit;

	    if (time.matches("^([0-9]?[1-9])[:]?([0-5][0-9])[. ]?([0-9][0-9])")) {
            timeSplit = time.split(":");
       		return (double)Integer.parseInt(timeSplit[0])*60 + Double.parseDouble(timeSplit[1]);

        }
        else if (time.matches("([0-5][0-9])[.]([0-9][0-9])")){
			System.out.println("le dur");
            return Double.valueOf(time);
        }
		else {
			System.out.println("siin vä " + time);
		    throw new NumberFormatException();
        }
	}
}
