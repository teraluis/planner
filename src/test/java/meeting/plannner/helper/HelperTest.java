package meeting.plannner.helper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import meeting.plannner.helper.Helper;
import meeting.plannner.repository.dao.RoomData;
import meeting.plannner.service.model.RoomType;

class HelperTest {

	@Test
	void testRoomRs() {
		final var room = new RoomData("rs_room", 5, false, false, false, false);
		assertEquals(RoomType.RS, Helper.getType(room));
	}

}
