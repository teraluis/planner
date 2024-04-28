package meeting.plannner.controller.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

	private String name;
	private Integer personnes;
	private Map<Integer, Boolean> bookings;

	public RoomDto(String name, Integer personnes, Map<Integer, Boolean> bookings) {
		this.name = name;
		this.personnes = personnes;
		this.bookings = bookings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Integer personnes) {
		this.personnes = personnes;
	}

	@JsonProperty("bookings")
	public Map<Integer, Boolean> getBookings() {
		return bookings;
	}

	public void setBookings(Map<Integer, Boolean> bookings) {
		this.bookings = bookings;
	}

}
