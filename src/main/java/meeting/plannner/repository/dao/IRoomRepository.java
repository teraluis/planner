package meeting.plannner.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import meeting.plannner.repository.entity.RoomData;

public interface IRoomRepository extends JpaRepository<RoomData, Long> {

}
