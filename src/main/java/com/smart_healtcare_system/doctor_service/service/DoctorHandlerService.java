package com.smart_healtcare_system.doctor_service.service;

import com.smart_healtcare_system.doctor_service.dto.request.DoctorDTORequest;
import com.smart_healtcare_system.doctor_service.dto.response.DoctorDTOResponse;

import java.util.List;

public interface DoctorHandlerService {

    DoctorDTOResponse createNewDoctor(DoctorDTORequest request);

    DoctorDTOResponse getDoctorById(Long doctorID);

    DoctorDTOResponse getDoctorBySSN(String doctorSSN);

    List<DoctorDTOResponse> getAllDoctors(int page, int size);

    List<DoctorDTOResponse> getDoctorsBySpecialization(String specialization);

    List<DoctorDTOResponse> getDoctorsByCity(String city);

}
