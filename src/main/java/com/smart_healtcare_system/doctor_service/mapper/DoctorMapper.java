package com.smart_healtcare_system.doctor_service.mapper;

import com.smart_healtcare_system.doctor_service.dto.request.DoctorDTORequest;
import com.smart_healtcare_system.doctor_service.dto.response.DoctorDTOResponse;
import com.smart_healtcare_system.doctor_service.model.Doctor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor mapDtoRequestToEntity(DoctorDTORequest doctorDTORequest);

    DoctorDTOResponse mapEntityToDtoResponse(Doctor doctor);

    List<DoctorDTOResponse> mapEntitiesToDtoResponses(List<Doctor> doctor);
}
