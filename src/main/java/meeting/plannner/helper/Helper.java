package meeting.plannner.helper;

import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.RoomType;

/**
 * this is a helper for the planner
 */
public class Helper {
	
	public static final boolean IS_PANDEMIE = true;
	
	public static RoomType getType(RoomData room) {
		
	    boolean hasCamera = room.isCamera();
	    boolean hasScreen = room.isScreen();
	    boolean hasSpeaker = room.isSpeaker();
	    boolean hasWhiteBoard = room.isWhiteBoard();

	    if (!hasCamera && !hasScreen && !hasSpeaker) {
	        return hasWhiteBoard ? RoomType.SPEC : RoomType.RS;
	    }

	    if (hasCamera && hasScreen && hasSpeaker) {
	        return hasWhiteBoard ? RoomType.RC : RoomType.VC;
	    }

	    return RoomType.RS;
	}

}
