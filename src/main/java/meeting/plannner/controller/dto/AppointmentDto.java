package meeting.plannner.controller.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDto {
	
	@Schema(description = "date of appointment format yyyy-mm-dd", example = "1999-01-28")
	private LocalDate date;
	private RoomDto room;

	public AppointmentDto(LocalDate time, RoomDto room) {
		this.date = time;
		this.room = room;
	}

}
