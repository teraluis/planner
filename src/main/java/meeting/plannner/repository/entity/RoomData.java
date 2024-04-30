package meeting.plannner.repository.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class RoomData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int capacite;
	private boolean whiteBoard;
	private boolean screen;
	private boolean camera;
	private boolean speaker;
	
	@OneToMany(mappedBy = "room")
	private List<AppointmentData> appointments;
	

}
