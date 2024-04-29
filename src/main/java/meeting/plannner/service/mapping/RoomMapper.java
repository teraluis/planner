package meeting.plannner.service.mapping;

import static meeting.plannner.helper.Helper.getType;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import meeting.plannner.helper.Helper;
import meeting.plannner.repository.entity.RoomData;
import meeting.plannner.service.model.Room;
import meeting.plannner.service.model.RoomType;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RoomMapper {

	RoomMapper INST = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "isPandemie", source = "source", qualifiedByName = "isPandemie")
    @Mapping(target = "capacity", ignore = true)
    @Mapping(target = "maxCapacity", source = "capacite")
    @Mapping(target = "type", source = "source", qualifiedByName = "computeRoomType")
    @Mapping(target = "bookings", ignore = true)
    @Mapping(target = "pandemie", ignore = true)
    Room map(RoomData source);

    @Named("computeRoomType")
    default RoomType computeRoomType(RoomData source) {
        return getType(source);
    }
    
    @Named("isPandemie")
    default boolean isPandemie(RoomData source) {
        return Helper.IS_PANDEMIE;
    }
}
