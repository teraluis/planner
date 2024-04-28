package meeting.plannner.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import meeting.plannner.repository.AppointmentRepository;
import meeting.plannner.repository.RoomsRepository;
import meeting.plannner.repository.dao.AppointmentData;
import meeting.plannner.repository.dao.RoomData;
import meeting.plannner.service.exceptions.RoomException;
import meeting.plannner.service.model.Appointement;

public class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomsRepository roomsRepository;
    
    @Mock
    private AppointmentRepository appointmentRepository;
    
    ArrayList<RoomData> rooms;
    ArrayList<AppointmentData> appointments;
    
    LocalDate monday;
    
    @BeforeEach
    public void setup() {
	    rooms = new ArrayList<RoomData>();
		
		rooms.add(new RoomData("E1001", 23, false, false, false, false));
		rooms.add(new RoomData("E1002", 10, false, true, false, false));
		rooms.add(new RoomData("E1003", 8, false, true, false, true));
		rooms.add(new RoomData("E1004", 4, true, false, false, false));
		
		rooms.add(new RoomData("E2001", 4, false, false, false, false));
		rooms.add(new RoomData("E2002", 15, false, true, true, false));
		rooms.add(new RoomData("E2003", 7, false, false, false, false));
		rooms.add(new RoomData("E2004", 9, true, false, false, false));
		
		rooms.add(new RoomData("E3001", 13, false, true, true, true));
		rooms.add(new RoomData("E3002", 8, false, false, false, false));
		rooms.add(new RoomData("E3003", 9, false, true, false, true));
		rooms.add(new RoomData("E3004", 4, false, false, false, false));
		
		monday = LocalDate.of(2024, 4, 22);
		
		appointments = new ArrayList<AppointmentData>();
		
		//ROOM 0
		appointments.add(new AppointmentData(rooms.get(0), monday, 9, 5));
		appointments.add(new AppointmentData(rooms.get(0), monday, 13, 8));
		appointments.add(new AppointmentData(rooms.get(0), monday, 17, 10));
		
		//ROOM 1
		appointments.add(new AppointmentData(rooms.get(1), monday, 9, 5));
		appointments.add(new AppointmentData(rooms.get(1), monday, 14, 5));
		appointments.add(new AppointmentData(rooms.get(1), monday, 16, 5));
		
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetByTypeAndPersons() {
    	
        Mockito.when(roomsRepository.getAll()).thenReturn(rooms);
        Mockito.when(appointmentRepository.getAll()).thenReturn(appointments);
        
    	assertEquals(12, roomService.getAll().size());
        final var roomsCall = roomService.getBy("RS", 3, monday);

        assertEquals(7, roomsCall.size());
        assertEquals(3, roomsCall.get(0).getBookings().size());
        assertEquals(0, roomsCall.get(2).getBookings().size());
    }

    @Test
    public void testBookFriday() throws Exception {
        final var roomName = "E1002";
        final var hour = 11;
        final var personnes = 3;
        final var friday = LocalDate.of(2024, 4, 26);
        
        Mockito.when(roomsRepository.getAll()).thenReturn(rooms);
        roomService.book(roomName, hour, personnes, friday);

        Mockito.verify(appointmentRepository, Mockito.times(1));
		appointmentRepository.add(Mockito.any(Appointement.class));
    }
    
    @Test
    public void testBookMonday() throws Exception {
        final var roomName = "E1002";
        final var hour = 11;
        final var personnes = 3;
        
        Mockito.when(roomsRepository.getAll()).thenReturn(rooms);
        Mockito.when(appointmentRepository.getAll()).thenReturn(appointments);
        roomService.book(roomName, hour, personnes, monday);

        Mockito.verify(appointmentRepository, Mockito.times(1));
		appointmentRepository.add(Mockito.any(Appointement.class));
    }
    
    @Test
    public void testNoRooms() throws Exception {
        final var roomName = "E1002";
        final var hour = 11;
        final var personnes = 3;
        
        Mockito.when(roomsRepository.getAll()).thenReturn(new ArrayList<RoomData>());
        Mockito.when(appointmentRepository.getAll()).thenReturn(new ArrayList<AppointmentData>());
        assertThrows(RoomException.class, () -> {
            roomService.book(roomName, hour, personnes, monday);
        });
    }
    
    @Test
    public void testBookSameHour() throws Exception {
        final var roomName = "E1002";
        final var hour = 16;
        final var personnes = 3;
        
        Mockito.when(roomsRepository.getAll()).thenReturn(rooms);
        Mockito.when(appointmentRepository.getAll()).thenReturn(appointments);

        assertThrows(RoomException.class, () -> {
            roomService.book(roomName, hour, personnes, monday);
        });
    }
    
    @Test
    public void testBookWeekEnd() throws Exception {
        final var roomName = "E1002";
        final var hour = 16;
        final var personnes = 3;
        
        Mockito.when(roomsRepository.getAll()).thenReturn(rooms);
        Mockito.when(appointmentRepository.getAll()).thenReturn(appointments);
        final var sunday = LocalDate.of(2024, 4, 28);
        assertThrows(RoomException.class, () -> {
            roomService.book(roomName, hour, personnes, sunday);
        });
    }

}
