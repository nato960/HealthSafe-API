package HealthSafe.domain.model.doctor;

import HealthSafe.domain.model.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DoctorCreateDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String crm,
        @NotBlank
        LocalDate birthDate,
        @NotBlank
        String phone,
        @NotBlank
        Speciality speciality,
        @NotNull
        @Valid
        AddressDto address) {
}
