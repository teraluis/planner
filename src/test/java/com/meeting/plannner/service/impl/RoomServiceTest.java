package com.meeting.plannner.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.meeting.plannner.repository.AppointmentRepository;
import com.meeting.plannner.repository.RoomsRepository;
import com.meeting.plannner.repository.dao.RoomData;
import com.meeting.plannner.service.exceptions.RoomException;
import com.meeting.plannner.service.impl.RoomService;
import com.meeting.plannner.service.model.Appointement;
import com.meeting.plannner.service.model.Room;

public class RoomServiceTest {

    @InjectMocks
    private RoomService roomService;

    @Mock
    private RoomsRepository roomsRepository;

    @Mock
    private AppointmentRepository appointmentRepository;
    
    ArrayList<RoomData> rooms;
    
    @BeforeEach
    public void setup() {
	    rooms = new ArrayList<RoomData>();
		
		//tableau ecran camera pieuvre
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
		
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Room room = new Room("test", 10, RoomService.IS_PANDEMIA, null);
        //Mockito.when(RoomsRepository.getAll()).thenReturn(rooms);

        List<Room> rooms = roomService.getAll();

        Assertions.assertEquals(1, rooms.size());
        Assertions.assertEquals(room, rooms.get(0));
    }

    @Test
    public void testGetBy() {
        //Mockito.when(RoomsRepository.getAll()).thenReturn(rooms);

        List<Room> rooms = roomService.getBy("RS", 10);

        Assertions.assertEquals(1, rooms.size());
        Assertions.assertEquals(rooms.get(0).getName(), "E1001");
    }

    @Test
    public void testBook() throws Exception {
        String roomName = "test";
        int hour = 1;
        int personnes = 10;
        LocalDate date = LocalDate.of(2024, 4, 26);

        roomService.book(roomName, hour, personnes, date);

        Mockito.verify(appointmentRepository, Mockito.times(1));
		AppointmentRepository.add(Mockito.any(Appointement.class));
    }

    @Test
    public void testBookException() {
        String roomName = "E1003";
        int hour = 5;
        int personnes = 20;
        LocalDate date = LocalDate.of(2024, 4, 27);

        Assertions.assertThrows(RoomException.class, () -> {
            roomService.book(roomName, hour, personnes, date);
        });
    }
}
