package com.meeting.plannner.controller.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Appointment {

	private LocalDate time;
	private RoomDto room;
	
}
