package com.meeting.plannner.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.meeting.plannner.controller.dto.AppointmentDto;
import com.meeting.plannner.controller.dto.ReservationForm;
import com.meeting.plannner.controller.dto.RoomDto;
import com.meeting.plannner.controller.mapping.RoomMappeur;
import com.meeting.plannner.service.impl.RoomService;

@RestController
@RequestMapping("/metting-room") 
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public ResponseEntity<List<RoomDto>> rooms(@RequestParam(defaultValue = "RS") String type, @RequestParam(defaultValue = "3") int personnes) {

		return ok(roomService.getBy(type, personnes).stream()
				.map(RoomMappeur.INST::map)
				.toList());		
	}
	
	@GetMapping("/rooms/{name}")
	public ResponseEntity<RoomDto> appointements(@PathVariable String name) {
		return ok(roomService.getAll().stream()
				.map(RoomMappeur.INST::map)
				.filter(r -> r.getName().equals(name))
				.findFirst().orElseThrow());		
	}
	
	@PostMapping("/rooms/:name/book")
	public ResponseEntity<AppointmentDto> book(@PathVariable String name, @RequestBody ReservationForm form) throws Exception {
		
		final var date = LocalDate.now();
		
		roomService.book(name, form.getHeure(), form.getPersonnes(), date);
		
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() 
                .path("/{name}") 
                .buildAndExpand(name)
                .toUri(); 
        
		return created(location).body(new AppointmentDto(date, new RoomDto(name, form.getPersonnes())));
	}
}
