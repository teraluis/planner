package meeting.plannner.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RoomRepositoryTest {
	
	RoomsRepository roomRepository;
	
	@BeforeAll
	static void setUpBeforeClass() {
	}

	@Test
	void test() {
		final var repo = new RoomsRepository();
		final var rooms = repo.getAll();		
		assertEquals(12, rooms.size());
	}

}
