package meeting.plannner.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.v3.oas.annotations.Hidden;
import meeting.plannner.repository.entity.AppointmentData;

@Hidden
public interface IAppointmentRepository extends JpaRepository<AppointmentData, Long> {
	
}
