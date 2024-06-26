package meeting.plannner.service.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.RoomType;

class RoomMappingTest {

	@Test
	void test() {
		final var data = new RoomData((long) 1, "room1", 20, false, false, false, false, null);
		final var room = RoomMapper.INST.map(data);
		
		assertEquals("room1", room.getName());
		assertEquals(RoomType.RS, room.getType());
		assertTrue(room.isPandemie());
	}

}
