package meeting.plannner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import meeting.plannner.repository.entity.AppointmentData;

public interface IAppointmentRepository extends JpaRepository<AppointmentData, Long> {
	
}
