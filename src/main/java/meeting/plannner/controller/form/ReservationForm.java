package meeting.plannner.controller.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ReservationForm {

	private int heure;
	private int personnes;
	private String date;

}
