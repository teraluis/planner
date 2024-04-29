package meeting.plannner.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

	private String name;
	private Integer personnes;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonProperty("bookings")
	private Set<Integer> bookings;

}
