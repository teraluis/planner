package com.meeting.plannner.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.meeting.plannner.repository.AppointmentRepository;
import com.meeting.plannner.repository.RoomsRepository;
import com.meeting.plannner.service.IRoom;
import com.meeting.plannner.service.exceptions.RoomException;
import com.meeting.plannner.service.mapping.RoomMapper;
import com.meeting.plannner.service.model.Appointement;
import com.meeting.plannner.service.model.Room;

@Service
public class RoomService implements IRoom {
	
	public static final boolean IS_PANDEMIA = true;
	
	@Override
	public List<Room> getAll(){
		return RoomsRepository.getAll().stream().map(RoomMapper.INST::map)
				.toList();
	}

	@Override
	public List<Room> getBy(String type, int personnes) {
		return getAll().stream()
				.filter(r -> type == r.getType().getName())
				.filter(r -> personnes < r.getCapacity())
				.toList();
	}

	@Override
	public void book(String roomName, int hour, int personnes, LocalDate date) throws Exception {
		final var room = new Room(roomName, personnes, IS_PANDEMIA, null);
		if(room.book(hour, personnes)) {
			AppointmentRepository.add(new Appointement(room, date));
		} else {
			throw new RoomException("you can't book this room");
		}		
	}
}
