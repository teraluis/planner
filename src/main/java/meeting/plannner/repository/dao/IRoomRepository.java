package meeting.plannner.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.v3.oas.annotations.Hidden;
import meeting.plannner.repository.entity.RoomData;

@Hidden
public interface IRoomRepository extends JpaRepository<RoomData, Long> {

}
