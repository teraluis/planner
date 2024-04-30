package meeting.plannner.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.RoomType;

class HelperTest {

	@Test
	void testRoomRs() {
		final var room = new RoomData((long) 3, "rs_room", 5, false, false, false, false, null);
		assertEquals(RoomType.RS, Helper.getType(room));
	}

}
