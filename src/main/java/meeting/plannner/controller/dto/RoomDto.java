package meeting.plannner.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Room of building")
public class RoomDto {

	@Schema(description = "room name", example = "E1001")
	private String name;
	@Schema(description = "number of persons in metting", example = "5")
	private Integer personnes;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonProperty("bookings")
	@Schema(description = "hours already booked", example = "[9, 13]")
	private Set<Integer> bookings;

}
