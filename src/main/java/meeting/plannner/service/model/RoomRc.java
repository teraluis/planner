package meeting.plannner.service.model;

/**
 * Coupled meetings (RC) between colleagues on site and teleworking which require a board, a screen
and an octopus.
 */
public class RoomRc extends Room {
	
	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;

	public RoomRc(String name, int maxCapacity, boolean pandemic) {
		super(name, maxCapacity, pandemic, RoomType.RC);
		screen = true;
		camera = false;
		speaker = true;
		whiteBoard = true;
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
