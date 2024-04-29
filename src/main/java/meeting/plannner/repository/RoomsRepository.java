package meeting.plannner.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import meeting.plannner.repository.entity.RoomData;

@Repository
public class RoomsRepository  {

	private static List<RoomData> rooms = new ArrayList<RoomData>();
	
	public List<RoomData> getAll() {		
		if(rooms.isEmpty()) {
			rooms.add(new RoomData("E1001", 23, false, false, false, false));
			rooms.add(new RoomData("E1002", 10, false, true, false, false));
			rooms.add(new RoomData("E1003", 8, false, true, false, true));
			rooms.add(new RoomData("E1004", 4, true, false, false, false));
			
			rooms.add(new RoomData("E2001", 4, false, false, false, false));
			rooms.add(new RoomData("E2002", 15, false, true, true, false));
			rooms.add(new RoomData("E2003", 7, false, false, false, false));
			rooms.add(new RoomData("E2004", 9, true, false, false, false));
			
			rooms.add(new RoomData("E3001", 13, false, true, true, true));
			rooms.add(new RoomData("E3002", 8, false, false, false, false));
			rooms.add(new RoomData("E3003", 9, false, true, false, true));
			rooms.add(new RoomData("E3004", 4, false, false, false, false));
		}

		return rooms;
	}
}
