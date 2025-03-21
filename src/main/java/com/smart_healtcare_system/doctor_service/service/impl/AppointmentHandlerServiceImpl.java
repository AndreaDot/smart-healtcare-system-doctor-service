package com.smart_healtcare_system.doctor_service.service.impl;

import com.smart_healtcare_system.doctor_service.dto.response.AppointmentDTOResponse;
import com.smart_healtcare_system.doctor_service.service.AppointmentHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentHandlerServiceImpl implements AppointmentHandlerService {

    @RabbitListener(queues = "${rabbitmq.queue.appointment.requests.name}")
    public void receiveAppointmentRequest(AppointmentDTOResponse appointmentDTOResponse){
        log.info("Richiesta di appuntamento ricevuta ->{}", appointmentDTOResponse.toString() );
    }

}
