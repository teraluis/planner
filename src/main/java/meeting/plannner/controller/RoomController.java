package meeting.plannner.controller;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import meeting.plannner.controller.dto.AppointmentDto;
import meeting.plannner.controller.dto.RoomDto;
import meeting.plannner.controller.form.ReservationForm;
import meeting.plannner.controller.mapping.RoomMappeur;
import meeting.plannner.service.impl.RoomService;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

@RestController
@RequestMapping("/metting-room") 
@Tag(name = "Meeting Room", description = "API for managing meeting rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
    @Operation(summary = "Get all meeting rooms", description = "Retrieve all meeting rooms based on given criteria")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved meeting rooms")
    })
	@GetMapping("/rooms")
	public ResponseEntity<List<RoomDto>> rooms(@RequestParam(defaultValue = "RS") String type, 
			@RequestParam(defaultValue = "3") int personnes, @RequestParam String date) {

		return ok(roomService.getBy(type, personnes, LocalDate.parse(date)).stream()
				.map(RoomMappeur.INST::map)
				.toList());		
	}
	
    @Operation(summary = "Get meeting rooms", description = "Retrieve meeting room by name and date")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved meeting room"),
        @ApiResponse(responseCode = "404", description = "meeting room not found", 
		content = {@Content(mediaType = "application/json", 
        schema = @Schema(implementation = HttpStatus.class))
		}),
    })
	@GetMapping("/rooms/{name}")
	public ResponseEntity<RoomDto> room(@PathVariable String name, @RequestParam String date) {
		return ok(roomService.getBy(name, LocalDate.parse(date)).stream()
				.map(RoomMappeur.INST::map)
				.filter(r -> r.getName().equals(name))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room not found")));		
	}
	
    @Operation(summary = "Book a room", description = "Book a room name in specific date")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully booked room"),
        @ApiResponse(responseCode = "400", description = "Can't book room", 
        		content = {@Content(mediaType = "application/json", 
                schema = @Schema(implementation = HttpStatus.class))
        		}),
    })    
	@PostMapping(path = "/rooms/{name}/book", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppointmentDto> book(@PathVariable String name, @RequestBody ReservationForm form) {	
		try {
			final var date = LocalDate.parse(form.getDate());
			roomService.book(name, form.getHeure(), form.getPersonnes(), date);
	        URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest() 
	                .path("/{name}") 
	                .buildAndExpand(name)
	                .toUri(); 
	                
			return created(location).body(new AppointmentDto(date, RoomDto.builder()
					.name(name)
					.personnes(form.getPersonnes())
					.bookings(Set.of(form.getHeure()))
					.build()));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can't book this room");
		}		
	}
}
