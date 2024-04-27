package com.meeting.plannner.repository;

import com.meeting.plannner.service.model.Appointement;

public class AppointmentRepository {

	public static void add(Appointement appointment) {
		System.out.println(appointment.getRoom().getName() + " booked ");
	}
}
