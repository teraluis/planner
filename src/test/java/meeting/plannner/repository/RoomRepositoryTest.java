package meeting.plannner.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import meeting.plannner.repository.RoomsRepository;

class RoomRepositoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		final var repo = new RoomsRepository();
		final var rooms = repo.getAll();		
		assertEquals(12, rooms.size());
	}

}
