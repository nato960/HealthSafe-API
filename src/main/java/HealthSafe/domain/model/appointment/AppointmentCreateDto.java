package HealthSafe.domain.model.appointment;

import HealthSafe.domain.model.doctor.Speciality;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentCreateDto(
        @NotNull
        Long idDoctor,
        @NotNull
        Long idPacient,
        @NotNull
        @Future
        LocalDateTime date,
        @NotNull
        Speciality speciality) {
}
