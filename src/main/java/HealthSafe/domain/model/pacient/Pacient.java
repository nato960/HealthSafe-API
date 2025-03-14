package HealthSafe.domain.model.pacient;

import HealthSafe.domain.model.address.Address;
import HealthSafe.domain.model.doctor.DoctorUpdateDto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_pacients")
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private LocalDate birthDate;

    private String phone;

    @Embedded
    private Address address;

    public Pacient() {}

    public Pacient(PacientCreateDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.cpf = dto.cpf();
        this.birthDate = dto.birthDate();
        this.phone = dto.phone();
        this.address = new Address(dto.address());
    }

    public void update(PacientUpdateDto dto) {
        if (dto.name() != null) {
            this.name = dto.name();
        }
        if (dto.phone() != null) {
            this.phone = dto.phone();
        }
        if (dto.address() != null) {
            this.address.update(dto.address());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

