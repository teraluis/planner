package meeting.plannner.controller.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
	
	private String name;
	private Integer personnes;
	private Map<Integer, Boolean> bookings;
	
	public RoomDto() {
		
	}

	public RoomDto(String name, Integer capacity) {	
		this.name = name;
		this.personnes = capacity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCapacity() {
		return personnes;
	}
	public void setCapacity(Integer capacity) {
		this.personnes = capacity;
	}

	public Integer getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Integer personnes) {
		this.personnes = personnes;
	}

	public Map<Integer, Boolean> getBookings() {
		return bookings;
	}

	public void setBookings(Map<Integer, Boolean> bookings) {
		this.bookings = bookings;
	}
	
}
