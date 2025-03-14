package HealthSafe.domain.model.doctor;

import HealthSafe.domain.model.address.AddressDto;
import jakarta.validation.constraints.NotNull;

public record DoctorUpdateDto(@NotNull
                              Long id,
                              String name,
                              String phone,
                              AddressDto address) {
}
