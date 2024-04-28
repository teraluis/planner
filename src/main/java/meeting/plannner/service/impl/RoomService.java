package meeting.plannner.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meeting.plannner.repository.AppointmentRepository;
import meeting.plannner.repository.RoomsRepository;
import meeting.plannner.service.IRoom;
import meeting.plannner.service.exceptions.RoomException;
import meeting.plannner.service.mapping.RoomMapper;
import meeting.plannner.service.model.Appointement;
import meeting.plannner.service.model.Room;

@Service
public class RoomService implements IRoom {
	
	@Autowired
	private RoomsRepository roomsRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public static final RoomException EXCEPTION = new RoomException("you can't book this room");
	private static final Logger logger = LoggerFactory.getLogger(RoomService.class);
	
	@Override
	public List<Room> getAll(){
		return roomsRepository.getAll()
				.stream().map(RoomMapper.INST::map)
				.toList();
	}

	@Override
	public List<Room> getBy(String type, int personnes, LocalDate date) {
		
		return computedRooms(date).stream()
				.filter(r -> type.equals(r.getType().getName()))				
				.filter(r -> personnes < r.getCapacity())
				.toList();
	}

	@Override
	public void book(String roomName, int hour, int personnes, LocalDate date) throws Exception {
		final var computedRoom = computedRooms(date).stream().filter(r -> r.getName().equals(roomName)).findFirst();
		
		if(computedRoom.isEmpty()) {
			throw EXCEPTION;				
		}
		
		if(computedRoom.isPresent()) {
			if(computedRoom.get().book(hour, personnes)) {
				try {
					appointmentRepository.add(new Appointement(computedRoom.get(), date));
				} catch (Exception e) {
					throw EXCEPTION;
				}
			}else {
				throw EXCEPTION;
			}
		}
	}
	
	/**
	 * this method will populate the hours reservation for a room from database
	 * @return
	 */
	protected List<Room> computedRooms(LocalDate date) {
		final var appointments = appointmentRepository.getAll().stream()
				.filter(a -> a.getDate().equals(date))
				.toList();
		
		return getAll().stream().map(room -> {
			final var appointmentsRoom = appointments.stream().filter(a -> room.getName() == a.getRoom().getName()).toList();			
			appointmentsRoom.forEach(ar -> room.book(ar.getHour(), ar.getPersonnes()));
			
			return room;
		}).toList();
	}
	
}
