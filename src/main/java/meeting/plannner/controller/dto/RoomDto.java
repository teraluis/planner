package meeting.plannner.controller.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Room of building")
public class RoomDto {

	@ApiModelProperty(notes = "room name", example = "E1001")
	private String name;
	@ApiModelProperty(notes = "number of persons in metting", example = "5")
	private Integer personnes;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonProperty("bookings")
	@ApiModelProperty(notes = "hours already booked", example = "[9, 13]")
	private Set<Integer> bookings;

}
