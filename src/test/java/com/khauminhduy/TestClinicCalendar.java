package com.khauminhduy;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestClinicCalendar {

	@Test
	void allowEntryOfAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("Khau", "Duy", "avery", "2022-02-23 12:00:00");
		List<PatientAppointment> appointments = calendar.getAppointments();
		assertEquals(1, appointments.size());
		PatientAppointment patientAppointment = appointments.get(0);
		assertEquals("Khau", patientAppointment.getPatientFirstName());
		assertEquals("Duy", patientAppointment.getPatientLastName());
	}

	@Test
	void allowEntryOfAppointmentV2() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("Khau", "Duy", "avery", "2022-02-23 12:00:00");
		List<PatientAppointment> appointments = calendar.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());
		PatientAppointment patientAppointment = appointments.get(0);
		assertAll(
			() -> assertEquals("Khau", patientAppointment.getPatientFirstName()),
			() -> assertEquals("Duy", patientAppointment.getPatientLastName())
		);

	}

	@Test
	void returnTrueForHasAppointmentIfThereAreAppointment() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		calendar.addAppointment("Khau", "Duy", "avery", "2022-02-24 00:00:00");
		assertTrue(calendar.hasAppointment(LocalDate.of(2022, 02, 24)));
	}

	@Test
	void returnFalseForHasAppointmentIfThereAreNoAppointment() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		assertFalse(calendar.hasAppointment(LocalDate.now()));
	}

	@Test
	void returnCurrentDayAppointment() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		calendar.addAppointment("Khau", "Duy", "avery", "2022-02-24 14:00:00");
		calendar.addAppointment("Khau2", "Duy2", "avery", "2022-02-24 15:00:00");
		calendar.addAppointment("Khau3", "Duy3", "avery", "2022-02-25 14:00:00");
		assertEquals(2, calendar.getTodayAppointment().size());
		assertEquals(3, calendar.getAppointments().size());
	}

	@Test
	void testThrowException() {
		ClinicCalendar calendar = new ClinicCalendar(LocalDate.now());
		assertThrows(Exception.class, () -> calendar.addAppointment("Khau", "Duy", "avery", "2022-02-24 12:00"));
	}


}
