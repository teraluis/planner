package meeting.plannner.service.model;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;

@Data
public class Room {

	private String name;
	private Integer capacity;
	private static final float PERCENT = 0.7f;
	private RoomType type;
	private Map<Integer, Boolean> bookings;
	private boolean isPandemie;
	private static final Logger logger = LoggerFactory.getLogger(Room.class);

	public Room(String name, int maxCapacity, boolean isPandemie, RoomType type) {
		bookings = new HashMap<Integer, Boolean>();
		this.name = name;		
		this.isPandemie = isPandemie;
		this.type = type;
		if(isPandemie) {
			logger.info("is pademic day business rules change");
			this.capacity = (int) (maxCapacity * PERCENT);
		} else {
			this.capacity = maxCapacity;
		}		
	}

	/**
	 * book a room for an hour and an amount of persons following the constraints
	 * @param hour
	 * @param persons
	 * @return
	 */
	public boolean book(int hour, int persons) {		
		final var bookable = hasCapacity(persons) && isOpen(hour) && isAvailable(hour);
		if(bookable) 
			bookings.put(hour, true);
		
		return bookable;
	}

	private boolean hasCapacity(int p) {
		return p <= capacity;
	}

	private boolean isOpen(int hour) {
		return (hour >= 8 && hour < 19);
	}

	private boolean isAvailable(int hour) {
		if(isPandemie) {
			return !(bookings.containsKey(hour) || bookings.containsKey(hour - 1) || bookings.containsKey(hour + 1));
		}
		return !bookings.containsKey(hour);
	}

	public String getName() {
		return name;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Map<Integer, Boolean> getBookings() {
		return bookings;
	}

	public void setBookings(Map<Integer, Boolean> bookings) {
		this.bookings = bookings;
	}

	public boolean isPandemie() {
		return isPandemie;
	}

	public void setPandemie(boolean isPandemie) {
		this.isPandemie = isPandemie;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
