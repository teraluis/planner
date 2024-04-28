package meeting.plannner.service.model;

import lombok.Builder;
import lombok.Data;

/***
 * Sharing and case study sessions (SPEC) which just require a table. The collaborators
arrange to be on site for this type of meeting;
 */
@Data
@Builder
public class RoomSpec extends Room {

	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;
	
	public RoomSpec(String name, int maxCapacity, boolean pandemic) {
		super(name, maxCapacity, pandemic, RoomType.SPEC);	
		whiteBoard = true;
		screen = false;
		camera = false;
		speaker = false;
	}

	public boolean isWhiteBoard() {
		return whiteBoard;
	}

	public void setWhiteBoard(boolean whiteBoard) {
		this.whiteBoard = whiteBoard;
	}

	public boolean isScreen() {
		return screen;
	}

	public void setScreen(boolean screen) {
		this.screen = screen;
	}

	public boolean isCamera() {
		return camera;
	}

	public void setCamera(boolean camera) {
		this.camera = camera;
	}

	public boolean isSpeaker() {
		return speaker;
	}

	public void setSpeaker(boolean speaker) {
		this.speaker = speaker;
	}

	
}
