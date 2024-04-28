package meeting.plannner.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import meeting.plannner.repository.dao.AppointmentData;
import meeting.plannner.service.model.Appointement;



@Repository
public class AppointmentRepository {

	@Autowired
	RoomsRepository appointmentRepository;
	
	public List<AppointmentData> getAll() {
		final var rooms = appointmentRepository.getAll();
		final var appointments = new ArrayList<AppointmentData>();
		final var monday = LocalDate.of(2024, 4, 22);
		
		appointments.add(new AppointmentData(rooms.get(0), monday, 9, 3));
		appointments.add(new AppointmentData(rooms.get(0), monday, 15, 3));
		appointments.add(new AppointmentData(rooms.get(0), monday, 17, 3));
		
		return appointments;
	}
	public void add(Appointement appointment) {
		System.out.println( "room booked ");
	}
}
