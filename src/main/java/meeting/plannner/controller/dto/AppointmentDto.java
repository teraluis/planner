package meeting.plannner.controller.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(description = "Appointment Dto")
public class AppointmentDto {
	
	@ApiModelProperty(notes = "date of appointment format yyyy-mm-dd", example = "1999-01-28")
	private LocalDate date;
	private RoomDto room;

	public AppointmentDto(LocalDate time, RoomDto room) {
		this.date = time;
		this.room = room;
	}

}
