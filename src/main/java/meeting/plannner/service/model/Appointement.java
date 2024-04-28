package meeting.plannner.service.model;

import java.time.LocalDate;

import lombok.Data;
import meeting.plannner.service.exceptions.AppointementException;

@Data
public class Appointement {

	private Room room;
	private LocalDate date;
	
	
	public Appointement(Room room, LocalDate date) throws Exception {
		this.room = room;
		this.date = date;
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
	
}
