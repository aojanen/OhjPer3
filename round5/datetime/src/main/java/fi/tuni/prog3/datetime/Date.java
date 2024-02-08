/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author ttakoj
 */
public class Date {

	@Override
	public String toString() {
		return String.format("%02d.%02d.%d", day, month, year);
	}

	private int year;
	private int month;
	private int day;

	public Date(int year, int month, int day) throws DateException {
		if (!isLegalDate(year, month, day)) {
			throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month, year));
		}
		this.day = day;
		this.month = month;
		this.year = year;

	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	static boolean isLegalDate(int year, int month, int day) {
		try {
			LocalDate date = LocalDate.of(year, month, day);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
