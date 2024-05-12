package meeting.plannner.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import meeting.plannner.repository.dao.IAppointmentRepository;
import meeting.plannner.repository.entity.AppointmentData;
import meeting.plannner.service.model.Appointement;

@Repository
public class AppointmentRepository {

	@Autowired
	RoomsRepository roomsRepository;
	
	@Autowired
	IAppointmentRepository dao;
	
	private static List<AppointmentData> appointments = new ArrayList<AppointmentData>();
	
	public List<AppointmentData> getAll() {
		final var rooms = roomsRepository.getAll();
		final var monday = LocalDate.of(2024, 4, 22);
		
		final var heures = new int[]{9,11,13, 15, 17};
		//this code is hear juste to show as exemple in the json body for the test case it should be destroy in production
		appointments = IntStream.range(0, heures.length)
				.mapToObj(i -> new AppointmentData((long) 1, monday, heures[i], 3, rooms.get(0)))
				.toList();
		
		return Stream.concat(appointments.parallelStream(), dao.findAll().parallelStream()).toList();
	}

	public void add(Appointement a) {	
		final var room = roomsRepository.getAll().stream().filter(r -> a.getRoom().getName().equals(r.getName())).findFirst();
		room.ifPresent(r -> {
			dao.save(new AppointmentData((long) 4, a.getDate(), a.getHour(), a.getPersons(), r));
		});				
	}
}
