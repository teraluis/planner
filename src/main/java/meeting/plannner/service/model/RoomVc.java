package meeting.plannner.service.model;

/**
 * ecran pieuvre webcam
 */
public class RoomVc extends Room {

	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;
	
	public RoomVc(String name, int maxCapacity, boolean pandemic) {
		super(name, maxCapacity, pandemic, RoomType.SPEC);		
		whiteBoard = false;
		screen = true;
		camera = true;
		speaker = true;
	}

	public boolean isWhiteBoard() {
		return whiteBoard;
	}

	public boolean isScreen() {
		return screen;
	}

	public boolean isCamera() {
		return camera;
	}

	public boolean isSpeaker() {
		return speaker;
	}

	
}
