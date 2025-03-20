package com.smart_healtcare_system.doctor_service.controller;

import com.smart_healtcare_system.doctor_service.constant.RestApiPath;
import com.smart_healtcare_system.doctor_service.dto.request.DoctorDTORequest;
import com.smart_healtcare_system.doctor_service.dto.response.DoctorDTOResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Operations for handle doctors
 */
@RequestMapping(RestApiPath.DOCTOR_BASE)
public interface DoctorHandlerController {

    @PostMapping
    ResponseEntity<DoctorDTOResponse> createNewDoctor(@Valid @RequestBody DoctorDTORequest doctorDTORequest);

    @GetMapping(RestApiPath.DOCTOR_BY_ID)
    ResponseEntity<DoctorDTOResponse> getDoctorById(@PathVariable Long doctorID);

    @GetMapping(RestApiPath.DOCTOR_BY_SSN)
    ResponseEntity<DoctorDTOResponse> getDoctorBySSN(@PathVariable String doctorSSN);

    @GetMapping
    ResponseEntity<List<DoctorDTOResponse>> getAllDoctors(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping(RestApiPath.DOCTOR_BY_SPECIALIZATION)
    ResponseEntity<List<DoctorDTOResponse>> getDoctorsBySpecialization(@PathVariable String specialization);

    @GetMapping(RestApiPath.DOCTOR_BY_CITY)
    ResponseEntity<List<DoctorDTOResponse>> getDoctorsByCity(@PathVariable String city);
}
