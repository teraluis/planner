package meeting.plannner.controller.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDto {

	private LocalDate date;
	private RoomDto room;

	public AppointmentDto(LocalDate time, RoomDto room) {
		this.date = time;
		this.room = room;
	}

}
