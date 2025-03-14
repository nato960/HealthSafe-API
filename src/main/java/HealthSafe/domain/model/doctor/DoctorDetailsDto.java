package HealthSafe.domain.model.doctor;

import HealthSafe.domain.model.address.Address;

import java.time.LocalDate;

public record DoctorDetailsDto(Long id, String name, String email, String crm, LocalDate birthDate, String phone, Speciality speciality, Address address) {

    public DoctorDetailsDto(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getBirthDate(), doctor.getPhone(), doctor.getSpecialty(), doctor.getAddress());
    }
}
