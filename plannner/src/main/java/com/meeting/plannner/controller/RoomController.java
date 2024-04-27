package com.meeting.plannner.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.plannner.controller.dto.RoomDto;

@RestController
@RequestMapping("/metting-planer") 
public class RoomController {

//	@GetMapping("/rooms")
//	public ResponseEntity<List<RoomDto>> getRooms() {
//		return null;		
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<RoomDto> getRoomById() {
//		return ResponseEntity.ok(new RoomDto());
//	}
}
