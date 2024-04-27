package com.meeting.plannner.service.model;

import java.util.Arrays;

public enum Day {
	MONDAY(1), THUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

	private final int day;

	Day(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public static Day fromDayNumber(int dayNumber) {

		return Arrays.stream(Day.values()).filter(day -> day.getDay() == dayNumber).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Invalid day number: " + dayNumber));

	}
}
