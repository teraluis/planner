package com.meeting.plannner.helper;

import com.meeting.plannner.repository.dao.RoomData;
import com.meeting.plannner.service.model.RoomType;

public class Helper {
	
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
