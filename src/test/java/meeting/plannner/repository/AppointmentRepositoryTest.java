package meeting.plannner.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import meeting.plannner.repository.entity.RoomData;

class AppointmentRepositoryTest {

	@InjectMocks
	private AppointmentRepository appointmentRepository;
	
	@Mock
	private RoomsRepository roomsRepository;
	
	private List<RoomData> rooms;
	
	@BeforeEach
	public void setup() {
		rooms = new ArrayList<>();
		rooms.add(new RoomData("", 0, false, false, false, false));
		rooms.add(new RoomData("", 0, false, false, false, false));
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void test() {
		when(roomsRepository.getAll()).thenReturn(rooms);
		final var rs = appointmentRepository.getAll();
		
		assertEquals(3, rs.size());
	}

}
