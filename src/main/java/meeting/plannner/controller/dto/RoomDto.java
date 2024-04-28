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
	@JsonProperty("bookings")
	private Map<Integer, Boolean> bookings;

}
