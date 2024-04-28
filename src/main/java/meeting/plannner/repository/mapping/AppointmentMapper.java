package meeting.plannner.repository.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import meeting.plannner.controller.dto.AppointmentDto;
import meeting.plannner.repository.entity.AppointmentData;
import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.Appointement;
import meeting.plannner.service.model.Room;

@Mapper
public interface AppointmentMapper {
	AppointmentMapper INST = Mappers.getMapper(AppointmentMapper.class);
	
	AppointmentData map(Appointement source);
	
}
