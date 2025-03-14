package HealthSafe.domain.model.pacient;

import HealthSafe.domain.model.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PacientCreateDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        LocalDate birthDate,
        @NotBlank
        String phone,
        @NotBlank
        @Valid
        AddressDto address
) {
}
