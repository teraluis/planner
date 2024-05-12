package meeting.plannner.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import meeting.plannner.repository.entity.RoomData;

@Repository
public class RoomsRepository  {
	
	private static final List<RoomData> rooms;
	
    static {
    	rooms = new ArrayList<RoomData>();
        rooms.add(new RoomData((long) 1, "E1001", 23, false, false, false, false, null));
        rooms.add(new RoomData((long) 2,"E1002", 10, false, true, false, false, null));
        rooms.add(new RoomData((long) 3, "E1003", 8, false, true, false, true, null));
        rooms.add(new RoomData((long) 4, "E1004", 4, true, false, false, false, null));
        rooms.add(new RoomData((long) 5, "E2001", 4, false, false, false, false, null));
        rooms.add(new RoomData((long) 6,"E2002", 15, false, true, true, false, null));
        rooms.add(new RoomData((long) 7,"E2003", 7, false, false, false, false, null));
        rooms.add(new RoomData((long) 8,"E2004", 9, true, false, false, false, null));
        rooms.add(new RoomData((long) 9,"E3001", 13, false, true, true, true, null));
        rooms.add(new RoomData((long) 10,"E3002", 8, false, false, false, false, null));
        rooms.add(new RoomData((long) 11,"E3003", 9, false, true, false, true, null));
        rooms.add(new RoomData((long) 12,"E3004", 4, false, false, false, false, null));
    }
	
    public List<RoomData> getAll() {       
        return Collections.unmodifiableList(rooms);
    }
}
