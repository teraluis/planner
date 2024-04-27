package com.meeting.plannner.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RoomRepositoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		final var rooms = RoomsRepository.getAll();		
		assertEquals(12, rooms.size());
	}

}
