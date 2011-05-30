package net.azib.java.students.t107110.homework;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author Eduard Shustrov
 */
public class ConsoleResultWriter implements ResultWriter {
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);
	private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("0.00");
	private static final NumberFormat SECONDS_FORMAT = new DecimalFormat("00.00");

	private static enum Column {
		PLACE, POINTS, NAME, BIRTHDAY, COUNTRY,
		RACE_100M, LONG_JUMP, SHOT_PUT, HIGH_JUMP, RACE_400M,
		HURDLES_110M, DISCUS_THROW, POLE_VAULT, JAVELIN_THROW, RACE_1500M;

		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}
	}

	private static enum Padding {LEFT, RIGHT}

	final List<Map<Column, String>> results = new LinkedList<Map<Column, String>>();
	final Map<Column, Integer> width = new EnumMap<Column, Integer>(Column.class);

	public ConsoleResultWriter() {
		final Map<Column, String> headerRow = new EnumMap<Column, String>(Column.class);
		for (final Column column : Column.values()) {
			final String columnName = column.toString();
			headerRow.put(column, columnName);
			width.put(column, columnName.length());
		}
		results.add(headerRow);
	}

	@Override
	public void write(String place, Result result) {
		final Map<Column, String> row = new EnumMap<Column, String>(Column.class);
		addCellToRowAndUpdateWidth(row, Column.PLACE, place);
		addCellToRowAndUpdateWidth(row, Column.POINTS, Integer.toString(result.getPoints()));
		addCellToRowAndUpdateWidth(row, Column.NAME, result.getAthleteName());
		addCellToRowAndUpdateWidth(row, Column.BIRTHDAY, formatDate(result.getBirthday()));
		addCellToRowAndUpdateWidth(row, Column.COUNTRY, result.getCountry());
		addCellToRowAndUpdateWidth(row, Column.RACE_100M, formatNumber(result.getSprint100m()));
		addCellToRowAndUpdateWidth(row, Column.LONG_JUMP, formatNumber(result.getLongJump()));
		addCellToRowAndUpdateWidth(row, Column.SHOT_PUT, formatNumber(result.getShotPut()));
		addCellToRowAndUpdateWidth(row, Column.HIGH_JUMP, formatNumber(result.getHighJump()));
		addCellToRowAndUpdateWidth(row, Column.RACE_400M, formatTime(result.getSprint400m()));
		addCellToRowAndUpdateWidth(row, Column.HURDLES_110M, formatNumber(result.getHurdles110m()));
		addCellToRowAndUpdateWidth(row, Column.DISCUS_THROW, formatNumber(result.getDiscusThrow()));
		addCellToRowAndUpdateWidth(row, Column.POLE_VAULT, formatNumber(result.getPoleVault()));
		addCellToRowAndUpdateWidth(row, Column.JAVELIN_THROW, formatNumber(result.getJavelinThrow()));
		addCellToRowAndUpdateWidth(row, Column.RACE_1500M, formatTime(result.getRace1500m()));
		results.add(row);
	}

	@Override
	public void close() {
		for (final Map<Column, String> row : results) {
			final StringBuilder builder = new StringBuilder();
			for (final Map.Entry<Column, String> entry : row.entrySet()) {
				if (builder.length() != 0) builder.append(" | ");
				switch (entry.getKey()) {
					case NAME:
					case BIRTHDAY:
					case COUNTRY:
						builder.append(pad(Padding.LEFT, entry));
						break;
					default:
						builder.append(pad(Padding.RIGHT, entry));
				}
			}
			System.out.println(builder.toString());
		}
	}

	private void addCellToRowAndUpdateWidth(final Map<Column, String> row, final Column column, final String text) {
		row.put(column, text);

		final int length = text.length();
		if (length > width.get(column)) width.put(column, length);
	}

	private static String formatDate(final Date date) {
		return DATE_FORMAT.format(date);
	}

	private static String formatNumber(final double number) {
		return NUMBER_FORMAT.format(number);
	}

	private static String formatTime(final double time) {
		final int minutes = (int) Math.floor(time) / 60;
		final double seconds = time - minutes * 60;
		return minutes + ":" + SECONDS_FORMAT.format(seconds);
	}

	private String pad(final Padding padding, final Map.Entry<Column, String> entry) {
		return String.format("%1$" + formatFlag(padding) + width.get(entry.getKey()) + "s", entry.getValue());
	}

	private String formatFlag(final Padding padding) {
		switch (padding) {
			case LEFT:
				return "-";
			case RIGHT:
			default:
				return "";
		}
	}
}
