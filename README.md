# HealthSafe
RESTful API of the HealthSafe application, containing CRUD functionalities for doctors and patients, as well as appointment scheduling.

This API is online (by Railway) for you to try it out on the link: https://healthsafe-api-prod.up.railway.app/swagger-ui/index.html#/

## Diagrama de Classes

``` mermaid

classDiagram

    class Patient {
        -id: Long
        -name: String
        -email: String
        -cpf: String
        -birthDate: LocalDate
        -phone: String
        -address: Address
        +Patient(PatientCreateDto dto)
        +update(PatientUpdateDto dto)
    }

    class Doctor {
        -id: Long
        -name: String
        -email: String
        -crm: String
        -birthDate: LocalDate
        -phone: String
        -specialty: Speciality
        -address: Address
        +Doctor(DoctorCreateDto dto)
        +update(DoctorUpdateDto dto)
    }

    class Address {
        -street: String
        -number: String
        -city: String
        -state: String
        -zipCode: String
        +Address(AddressDto dto)
        +update(AddressDto dto)
    }

    class Appointment {
        -id: Long
        -doctor: Doctor
        -patient: Patient
        -date: LocalDateTime
        +Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime date)
        +reschedule(AppointmentUpdateDto dto)
    }

    %% Relationships
    Doctor "1" -->  "n" Appointment
    Patient "1" -->  "n" Appointment
    Address --o Patient : embedded in
    Address --o Doctor : embedded in

```


