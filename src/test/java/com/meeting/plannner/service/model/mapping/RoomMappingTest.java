package com.meeting.plannner.service.model.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.meeting.plannner.repository.dao.RoomData;
import com.meeting.plannner.service.mapping.RoomMapper;

class RoomMappingTest {

	@Test
	void test() {
		final var data = new RoomData("room1", 20, false, false, false, false);
		final var room = RoomMapper.INST.map(data);
		
		assertEquals("room1", room.getName());
	}

}
