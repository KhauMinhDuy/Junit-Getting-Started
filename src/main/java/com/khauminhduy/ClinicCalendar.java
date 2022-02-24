package com.khauminhduy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ClinicCalendar {

	private List<PatientAppointment> appointments;

	public ClinicCalendar() {
		appointments = new ArrayList<>();
	}

	public void addAppointment(String patientFirstName, String patientLastName, String dockerKey, String dateTime) {
		Doctor doctor = Doctor.valueOf(dockerKey);
		LocalDateTime localDateTime = null;
		try {
			localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		PatientAppointment patientAppointment = new PatientAppointment(patientFirstName, patientLastName, localDateTime,
				doctor);
		appointments.add(patientAppointment);
	}

}
