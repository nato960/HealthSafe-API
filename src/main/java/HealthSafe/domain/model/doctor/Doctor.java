package HealthSafe.domain.model.doctor;

import HealthSafe.domain.model.address.Address;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "tb_doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(unique = true)
    private String crm;

    private LocalDate birthDate;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Speciality specialty;

    @Embedded
    private Address address;


    public Doctor() {}

    public Doctor(DoctorCreateDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.crm = dto.crm();
        this.birthDate = dto.birthDate();
        this.phone = dto.phone();
        this.specialty = dto.speciality();
        this.address = new Address(dto.address());
    }

    public void update(DoctorUpdateDto dto) {
        if(dto.name() != null){
            this.name = dto.name();
        }
        if(dto.phone() != null){
            this.phone = dto.phone();
        }
        if(dto.address() != null){
            this.address.update(dto.address());
        }


    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Speciality getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Speciality specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


