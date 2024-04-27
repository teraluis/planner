package com.meeting.plannner.controller.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppointmentDto {

	private LocalDate time;
	private RoomDto room;
	public AppointmentDto(LocalDate time, RoomDto room) {
		this.time = time;
		this.room = room;
	}

}
