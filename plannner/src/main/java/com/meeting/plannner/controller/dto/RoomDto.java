package com.meeting.plannner.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
	
	private String name;
	private Integer capacity;
		
}
