package meeting.plannner.controller.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import meeting.plannner.controller.dto.RoomDto;
import meeting.plannner.service.model.Room;

@Mapper
public interface RoomMappeur {
	RoomMappeur INST = Mappers.getMapper(RoomMappeur.class);

	RoomDto map(Room room);
}
