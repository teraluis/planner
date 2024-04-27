package com.meeting.plannner.repository.dao;

public class AppointmentData {
	
	private String name;
	private int horaire;
	private String type;
	private int personnes;
	
	
	public AppointmentData(String name, int horaire, String type, int personnes) {
		this.name = name;
		this.horaire = horaire;
		this.type = type;
		this.personnes = personnes;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHoraire() {
		return horaire;
	}
	public void setHoraire(int horaire) {
		this.horaire = horaire;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPersonnes() {
		return personnes;
	}
	public void setPersonnes(int personnes) {
		this.personnes = personnes;
	}
	
	
}
