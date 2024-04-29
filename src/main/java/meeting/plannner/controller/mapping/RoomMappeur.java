package meeting.plannner.controller.mapping;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import meeting.plannner.controller.dto.RoomDto;
import meeting.plannner.service.model.Room;

@Mapper
public interface RoomMappeur {
	RoomMappeur INST = Mappers.getMapper(RoomMappeur.class);

	@Mapping(source = "capacity", target = "personnes")
	@Mapping(source = "bookings", target = "bookings", qualifiedByName = "hours")
	RoomDto map(Room room);
	
    @Named("hours")
    default Set<Integer> computeRoomType(Map<Integer, Boolean> bookings) {
        return bookings.entrySet().stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }
}
