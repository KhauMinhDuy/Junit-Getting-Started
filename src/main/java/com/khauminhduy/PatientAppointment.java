package com.khauminhduy;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointment {

	private String patientFirstName;
	private String patientLastName;
	private LocalDateTime appointmentDateTime;
	private Doctor doctor;
	
}
