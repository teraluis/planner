package meeting.plannner.repository.dao;

import java.time.LocalDate;

public class AppointmentData {

	private RoomData room;
	private LocalDate date;
	private int hour;
	private int personnes;

	public AppointmentData(RoomData room, LocalDate date, int hour, int personnes) {
		this.room = room;
		this.date = date;
		this.hour = hour;
		this.personnes = personnes;
	}

	public RoomData getRoom() {
		return room;
	}

	public void setRoom(RoomData room) {
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

	public int getPersonnes() {
		return personnes;
	}

	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}
	
}
