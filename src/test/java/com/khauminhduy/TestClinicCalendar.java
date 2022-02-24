package com.khauminhduy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class TestClinicCalendar {

	@Test
	public void allowEntryOfAppointment() {
		ClinicCalendar calendar = new ClinicCalendar();
		calendar.addAppointment("Khau", "Duy", "avery", "2022-02-23 12:00:00");
		List<PatientAppointment> appointments = calendar.getAppointments();
		assertNotNull(appointments);
		assertEquals(1, appointments.size());
	}
	
}
