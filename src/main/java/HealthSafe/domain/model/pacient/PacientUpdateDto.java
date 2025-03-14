package HealthSafe.domain.model.pacient;

import HealthSafe.domain.model.address.AddressDto;
import jakarta.validation.constraints.NotNull;

public record PacientUpdateDto(@NotNull
                               Long id,
                               String name,
                               String phone,
                               AddressDto address

) {
}
