package meeting.plannner.repository.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentData {
	
	private RoomData room;
	private LocalDate date;
	private int hour;
	private int personnes;

}
