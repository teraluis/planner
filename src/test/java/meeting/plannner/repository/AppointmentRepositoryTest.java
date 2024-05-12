package meeting.plannner.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import meeting.plannner.repository.dao.IAppointmentRepository;
import meeting.plannner.repository.entity.AppointmentData;
import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.Appointement;
import meeting.plannner.service.model.Room;
import meeting.plannner.service.model.RoomType;

@ExtendWith(MockitoExtension.class)
class AppointmentRepositoryTest {

	@InjectMocks
	private AppointmentRepository appointmentRepository;

	@Mock
	private RoomsRepository roomsRepository;

	@Mock
	private IAppointmentRepository dao;

	private List<RoomData> rooms;
	private static final LocalDate DATE = LocalDate.of(2015, 9, 1);
	private static List<AppointmentData> daoAppointments;

	@BeforeEach
	public void setup() {
		rooms = new ArrayList<>();
		rooms.add(new RoomData((long) 1, "one", 5, false, false, false, false, null));
		rooms.add(new RoomData((long) 2, "two", 2, false, false, false, false, null));
		daoAppointments = IntStream.range(1, 6).mapToObj(i -> new AppointmentData(null, DATE, i + 9, 6, rooms.get(0)))
				.collect(Collectors.toList());

		when(roomsRepository.getAll()).thenReturn(rooms);
	}

	@Test
	void test() {
		when(dao.findAll()).thenReturn(daoAppointments);
		final var rs = appointmentRepository.getAll();
		assertTrue(rs.size() > 0);		
	    verify(roomsRepository).getAll();
	    verify(dao).findAll();
	}

	@Test
	void testSave() throws Exception {		
		
		appointmentRepository.add(new Appointement(new Room("one", 50, true, RoomType.RS), LocalDate.of(2015, 9, 1), 9, 6));
		
	    verify(roomsRepository).getAll();
	    verify(dao).save(any(AppointmentData.class));
	}

}
