package meeting.plannner.service.model;

public enum RoomType {
	VC("VC"), SPEC("SPEC"),RS("RS"),RC("RC");

	private final String type;

	RoomType(String t) {
		this.type = t;
	}

	public String getName() {
		return type;
	}
}
