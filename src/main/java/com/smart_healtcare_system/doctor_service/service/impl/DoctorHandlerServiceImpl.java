package com.smart_healtcare_system.doctor_service.service.impl;

import com.smart_healtcare_system.doctor_service.dto.request.DoctorDTORequest;
import com.smart_healtcare_system.doctor_service.dto.response.DoctorDTOResponse;
import com.smart_healtcare_system.doctor_service.mapper.DoctorMapper;
import com.smart_healtcare_system.doctor_service.model.Doctor;
import com.smart_healtcare_system.doctor_service.repository.DoctorRepository;
import com.smart_healtcare_system.doctor_service.service.DoctorHandlerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorHandlerServiceImpl implements DoctorHandlerService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorDTOResponse createNewDoctor(DoctorDTORequest request) {
        Optional<Doctor> doctorBySsn = doctorRepository.findBySsn(request.getSsn());
        if (doctorBySsn.isEmpty()) {
            Doctor doctor = doctorMapper.mapDtoRequestToEntity(request);
            Doctor doctorSaved = doctorRepository.save(doctor);
            return doctorMapper.mapEntityToDtoResponse(doctorSaved);
        }
        return null;
    }

    @Override
    public DoctorDTOResponse getDoctorById(Long doctorID) {
        Optional<Doctor> doctorById = doctorRepository.findById(doctorID);
        return doctorById.map(doctorMapper::mapEntityToDtoResponse).orElse(null);
    }

    @Override
    public DoctorDTOResponse getDoctorBySSN(String doctorSSN) {
        Optional<Doctor> doctorById = doctorRepository.findBySsn(doctorSSN);
        return doctorById.map(doctorMapper::mapEntityToDtoResponse).orElse(null);
    }

    @Override
    public List<DoctorDTOResponse> getAllDoctors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Doctor> allDoctors = doctorRepository.findAll(pageable);
        if (!allDoctors.isEmpty()) {
            return doctorMapper.mapEntitiesToDtoResponses(allDoctors.getContent());
        }
        return null;
    }

    @Override
    public List<DoctorDTOResponse> getDoctorsBySpecialization(String specialization) {
        List<Doctor> doctorsBySpecialization = doctorRepository.findBySpecialization(specialization);
        if (Objects.nonNull(doctorsBySpecialization) && !doctorsBySpecialization.isEmpty()) {
            return doctorMapper.mapEntitiesToDtoResponses(doctorsBySpecialization);
        }
        return null;
    }

    @Override
    public List<DoctorDTOResponse> getDoctorsByCity(String city) {
        List<Doctor> doctorsByCity = doctorRepository.findByCity(city);
        if (Objects.nonNull(doctorsByCity) && !doctorsByCity.isEmpty()) {
            return doctorMapper.mapEntitiesToDtoResponses(doctorsByCity);
        }
        return null;
    }
}
