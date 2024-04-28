package meeting.plannner.service.model;

import java.time.LocalDate;

import lombok.Data;
import meeting.plannner.service.exceptions.AppointementException;

@Data
public class Appointement {

	private Room room;
	private LocalDate date;
	private int hour;
	private int persons;
	
	
	public Appointement(Room room, LocalDate date, int hour, int persons) throws Exception {
		this.room = room;
		this.date = date;
		this.hour = hour;
		this.persons = persons;
		if(date.getDayOfWeek().getValue() > 5) {
			throw new AppointementException("You can not book in weekends");
		}
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}
}
