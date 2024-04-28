package meeting.plannner.repository.entity;

public class RoomData {

	private String name;
	private int capacite;
	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;

	public RoomData(String name, int capacite, boolean whiteBoard, boolean screen, boolean camera, boolean speaker) {
		this.name = name;
		this.capacite = capacite;
		this.whiteBoard = whiteBoard;
		this.screen = screen;
		this.camera = camera;
		this.speaker = speaker;
	}

	public int getCapacite() {
		return capacite;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
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
