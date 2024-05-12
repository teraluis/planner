package meeting.plannner.repository.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class AppointmentData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	private LocalDate date;
	private int heure;
	private int personnes;
	
	@ManyToOne
	@JoinColumn(name = "romm_id")
	private RoomData room;

}
