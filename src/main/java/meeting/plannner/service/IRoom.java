package meeting.plannner.service;

import java.time.LocalDate;
import java.util.List;

import meeting.plannner.service.model.Room;

public interface IRoom {

	public List<Room> getAll();
	
	public List<Room> getBy(String type, int personnes, LocalDate date);
	
	public List<Room> getBy(String name, LocalDate date);
	
	public void book(String roomName, int hour, int personnes, LocalDate date) throws Exception; 
}
