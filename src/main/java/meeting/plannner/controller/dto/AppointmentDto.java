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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}

}
