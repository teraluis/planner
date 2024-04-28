package meeting.plannner.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import meeting.plannner.controller.dto.AppointmentDto;
import meeting.plannner.controller.dto.ReservationForm;
import meeting.plannner.controller.dto.RoomDto;
import meeting.plannner.controller.mapping.RoomMappeur;
import meeting.plannner.service.impl.RoomService;

@RestController
@RequestMapping("/metting-room") 
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/rooms")
	public ResponseEntity<List<RoomDto>> rooms(@RequestParam(defaultValue = "RS") String type, 
			@RequestParam(defaultValue = "3") int personnes, @RequestParam String date) {

		return ok(roomService.getBy(type, personnes, LocalDate.parse(date)).stream()
				.map(RoomMappeur.INST::map)
				.toList());		
	}
	
	@GetMapping("/rooms/{name}")
	public ResponseEntity<RoomDto> room(@PathVariable String name) {
		return ok(roomService.getAll().stream()
				.map(RoomMappeur.INST::map)
				.filter(r -> r.getName().equals(name))
				.findFirst().orElseThrow());		
	}
	
	@PostMapping(path = "/rooms/{name}/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppointmentDto> book(@PathVariable String name, @RequestBody ReservationForm form) throws Exception {
		
		final var date = LocalDate.parse(form.getDate());
		roomService.book(name, form.getHeure(), form.getPersonnes(), date);
		
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() 
                .path("/{name}") 
                .buildAndExpand(name)
                .toUri(); 
                
		return created(location).body(new AppointmentDto(date, new RoomDto(name, form.getPersonnes(), Map.of(form.getHeure(), true))));
	}
}
