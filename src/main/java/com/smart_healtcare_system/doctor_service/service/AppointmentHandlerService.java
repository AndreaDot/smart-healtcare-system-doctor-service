package com.smart_healtcare_system.doctor_service.service;

import com.smart_healtcare_system.doctor_service.dto.response.AppointmentDTOResponse;

public interface AppointmentHandlerService {

    void receiveAppointmentRequest(AppointmentDTOResponse appointmentDTOResponse);
}
