package meeting.plannner.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import meeting.plannner.repository.entity.AppointmentData;
import meeting.plannner.service.model.Appointement;

@Repository
public class AppointmentRepository {

	@Autowired
	RoomsRepository roomsRepository;
	
	private static List<AppointmentData> appointments = new ArrayList<AppointmentData>();
	
	public List<AppointmentData> getAll() {
		final var rooms = roomsRepository.getAll();
		final var monday = LocalDate.of(2024, 4, 22);
		
		if(appointments.isEmpty()) {
			appointments.add(new AppointmentData((long) 1, monday, 9, 3, rooms.get(0)));
			appointments.add(new AppointmentData((long) 2, monday, 15, 3, rooms.get(0)));
			appointments.add(new AppointmentData((long) 3, monday, 17, 3, rooms.get(0)));
		}

		return appointments;
	}

	public void add(Appointement a) {	
		final var room = roomsRepository.getAll().stream().filter(r -> a.getRoom().getName().equals(r.getName())).findFirst();
		room.ifPresent(r -> {
			appointments.add(new AppointmentData((long) 4, a.getDate(), a.getHour(), a.getPersons(), r));		
		});				
	}
}
