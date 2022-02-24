package com.khauminhduy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class ClinicCalendar {

	private List<PatientAppointment> appointments;
	private LocalDate today;

	public ClinicCalendar() {
		appointments = new ArrayList<>();
	}

	public ClinicCalendar(LocalDate today) {
		this.today = today;
		this.appointments = new ArrayList<>();
	}

	public void addAppointment(String patientFirstName, String patientLastName, String dockerKey, String dateTime) {
		Doctor doctor = Doctor.valueOf(dockerKey);
		LocalDateTime localDateTime = convertDateTimefromString(dateTime);
		PatientAppointment patientAppointment = new PatientAppointment(patientFirstName, patientLastName, localDateTime,
				doctor);
		appointments.add(patientAppointment);
	}

	public List<PatientAppointment> getTodayAppointment() {
		return appointments.stream().filter(appt -> appt.getAppointmentDateTime().toLocalDate().equals(today))
				.collect(Collectors.toList());
	}

	public boolean hasAppointment(LocalDate date) {
		return appointments.stream().anyMatch(appt -> appt.getAppointmentDateTime().toLocalDate().equals(date));
	}

	private LocalDateTime convertDateTimefromString(String dateTime) {
		LocalDateTime localDateTime = null;
		try {
			localDateTime = LocalDateTime.parse(dateTime.toUpperCase(),
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return localDateTime;
	}

}
