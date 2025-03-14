package HealthSafe.domain.model.appointment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentUpdateDto(@NotNull
                                   Long id,
                                   LocalDateTime date
                                   ) {
}
