package com.smart_healtcare_system.doctor_service.controller.impl;

import com.smart_healtcare_system.doctor_service.controller.DoctorHandlerController;
import com.smart_healtcare_system.doctor_service.dto.request.DoctorDTORequest;
import com.smart_healtcare_system.doctor_service.dto.response.DoctorDTOResponse;
import com.smart_healtcare_system.doctor_service.service.DoctorHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class DoctorHandlerControllerImpl implements DoctorHandlerController {
    private final DoctorHandlerService doctorHandlerService;

    @Override
    public ResponseEntity<DoctorDTOResponse> createNewDoctor(DoctorDTORequest doctorDTORequest) {
        DoctorDTOResponse newDoctor = doctorHandlerService.createNewDoctor(doctorDTORequest);
        if(Objects.nonNull(newDoctor)){
            return ResponseEntity.status(HttpStatus.CREATED).body(newDoctor);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @Override
    public ResponseEntity<DoctorDTOResponse> getDoctorById(Long doctorID) {
        DoctorDTOResponse doctorById = doctorHandlerService.getDoctorById(doctorID);
        if(Objects.nonNull(doctorById)){
            return ResponseEntity.status(HttpStatus.OK).body(doctorById);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<DoctorDTOResponse> getDoctorBySSN(String doctorSSN) {
        DoctorDTOResponse doctorBySSN = doctorHandlerService.getDoctorBySSN(doctorSSN);
        if(Objects.nonNull(doctorBySSN)){
            return ResponseEntity.status(HttpStatus.OK).body(doctorBySSN);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<DoctorDTOResponse>> getAllDoctors(int page, int size) {
        List<DoctorDTOResponse> allDoctors = doctorHandlerService.getAllDoctors(page, size);
        if(Objects.nonNull(allDoctors) && !allDoctors.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(allDoctors);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<DoctorDTOResponse>> getDoctorsBySpecialization(String specialization) {
        List<DoctorDTOResponse> doctorsBySpecialization = doctorHandlerService.getDoctorsBySpecialization(specialization);
        if(Objects.nonNull(doctorsBySpecialization) && !doctorsBySpecialization.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(doctorsBySpecialization);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<List<DoctorDTOResponse>> getDoctorsByCity(String city) {
        List<DoctorDTOResponse> doctorsByCity = doctorHandlerService.getDoctorsByCity(city);
        if(Objects.nonNull(doctorsByCity) && !doctorsByCity.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(doctorsByCity);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
