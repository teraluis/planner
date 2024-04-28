package meeting.plannner.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomData {

	private String name;
	private int capacite;
	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;

}
