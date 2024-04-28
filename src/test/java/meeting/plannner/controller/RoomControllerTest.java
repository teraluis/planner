package meeting.plannner.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import meeting.plannner.controller.dto.ReservationForm;
import meeting.plannner.service.impl.RoomService;
import meeting.plannner.service.model.Room;
import meeting.plannner.service.model.RoomType;


@ExtendWith(MockitoExtension.class)
public class RoomControllerTest {

	@InjectMocks
	private RoomController roomController;

	@Mock
	private RoomService roomService;

	@BeforeEach
	public void setup() {
		final var request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testRoomsFound() {				
		when(roomService.getBy(anyString(), anyInt(), any(LocalDate.class))).thenReturn(List.of(new Room("E1", 0, true, RoomType.RS)));
        final var response = roomController.rooms("RS", 3, "2024-04-15");

        assertEquals(OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());     
	}
	
	@Test
	public void testRoomFound() {
        when(roomService.getAll()).thenReturn(List.of(new Room("E1", 0, true, RoomType.RS)));

        final var response = roomController.room("E1");

        assertEquals(OK, response.getStatusCode());
        assertEquals("E1", response.getBody().getName());
        verify(roomService).getAll();
	}

	@Test
	public void testBookRoom() throws Exception {
		final var name = "E1001";
		final var date = "2024-04-30";
		final var heure = 10;
		int personnes = 3;

		final var form = new ReservationForm();
		form.setDate(date);
		form.setHeure(heure);
		form.setPersonnes(personnes);

		doNothing().when(roomService).book(anyString(), anyInt(), anyInt(), any(LocalDate.class));

		final var request = new MockHttpServletRequest();
		request.setRequestURI("/meeting-room/rooms/" + name + "/book");
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		// Execute
		final var response = roomController.book(name, form);

		// Verify
		assertEquals(201, response.getStatusCode().value());
		URI expectedUri = new URI("http://localhost/meeting-room/rooms/" + name + "/book/" + name);

		assertEquals(expectedUri, response.getHeaders().getLocation());
		verify(roomService).book(name, heure, personnes, LocalDate.parse(date));
	}
}
