package com.meeting.plannner.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.meeting.plannner.service.model.Room;
import com.meeting.plannner.service.model.RoomType;

class RoomTest {

	public static LocalDate MONDAY = LocalDate.of(2024, 4, 22);
	public static LocalDate SATURDAY = LocalDate.of(2024, 4, 27);
	public static LocalDate SUNDAY = LocalDate.of(2024, 4, 28);
	@Test
	void testBooking() {
		final var room = new Room("Jupiter", 10, false, RoomType.RC);
		final var booked = room.book(9, 5);
		assertTrue(booked);
		assertEquals("Jupiter", room.getName());
		assertEquals(RoomType.RC, room.getType());
	}
	

	@Test
	void testPandemic() {
		final var room = new Room("Neptune", 10, true, RoomType.RC);
		final var booked = room.book(9, 8);
		assertFalse(booked);
	}
	
	@Test
	void testBookedBefore() {
		final var room = new Room("Terre", 10, true, RoomType.RC);
		
		final var bookings = new Boolean[]{room.book(9, 5), room.book(10, 5)};
		assertTrue(bookings[0]);
		assertFalse(bookings[1]);
	}
	
	@Test
	void testBookedAfter() {
		final var room = new Room("Uranus", 10, true, RoomType.RC);
		
		final var bookings = new Boolean[]{room.book(10, 5), room.book(9, 5)};
		assertTrue(bookings[0]);
		assertFalse(bookings[1]);
	}
	
	@Test
	void testAlreadyBooked() {
		final var room = new Room("Jupiter", 10, false, RoomType.RC);
		
		final var bookings = new Boolean[]{room.book(9, 5), room.book(9, 9)};
		assertTrue(bookings[0]);
		assertFalse(bookings[1]);
	}
	
	@Test
	void testAlreadyBookedPandemie() {
		final var room = new Room("Mars", 10, true, RoomType.RC);
		
		final var bookings = new Boolean[]{room.book(9, 5), room.book(9, 3)};
		assertTrue(bookings[0]);
		assertFalse(bookings[1]);
	}
	
	@Test
	void testBookedAfter18h() {
		final var room = new Room("Jupiter", 10, false, RoomType.RC);
		
		final var isBooked = room.book(22, 5);
		assertFalse(isBooked);
	}
	
	@Test
	void testBookedBefore08h() {
		final var room = new Room("Jupiter", 10, false, RoomType.RC);
		
		final var isBooked = room.book(5, 5);
		assertFalse(isBooked);
	}
}
