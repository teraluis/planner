package com.meeting.plannner.service;

import java.time.LocalDate;
import java.util.List;

import com.meeting.plannner.service.model.Room;

public interface IRoom {

	public List<Room> getAll();
	
	public List<Room> getBy(String type, int personnes, int hour);
	
	public void book(String roomName, int hour, int personnes, LocalDate date) throws Exception; 
}
