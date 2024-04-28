package meeting.plannner.controller.dto;

public class ReservationForm {
	
	
	private int heure;
	private int personnes;
	private String date;
	
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	public int getPersonnes() {
		return personnes;
	}
	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
