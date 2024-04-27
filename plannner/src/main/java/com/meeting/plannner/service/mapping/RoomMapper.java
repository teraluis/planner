package com.meeting.plannner.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import static com.meeting.plannner.helper.Helper.getType;
import com.meeting.plannner.repository.dao.RoomData;
import com.meeting.plannner.service.model.Room;
import com.meeting.plannner.service.model.RoomType;

@Mapper
public interface RoomMapper {

	RoomMapper INST = Mappers.getMapper(RoomMapper.class);

	@Mapping(target = "isPandemie", constant = "true")
	@Mapping(target = "type", qualifiedByName = "computeType")
	Room map(RoomData room);

	@Named("computeType")
	default RoomType computeType(RoomData room) {
		return getType(room);
	}
}
