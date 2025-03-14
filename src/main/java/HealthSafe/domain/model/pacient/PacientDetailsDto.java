package HealthSafe.domain.model.pacient;

import HealthSafe.domain.model.address.Address;

import java.time.LocalDate;

public record PacientDetailsDto(Long id, String name, String email, String cpf, LocalDate birthDate, String phone, Address address) {

    public PacientDetailsDto(Pacient pacient){
        this(pacient.getId(), pacient.getName(), pacient.getEmail(), pacient.getCpf(), pacient.getBirthDate(), pacient.getPhone(),  pacient.getAddress());
    }
}
