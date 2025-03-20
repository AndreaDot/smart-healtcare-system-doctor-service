package com.smart_healtcare_system.doctor_service.repository;

import com.smart_healtcare_system.doctor_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findBySsn(String ssn);

    List<Doctor> findBySpecialization(String specialization);

    List<Doctor> findByCity(String city);
}
