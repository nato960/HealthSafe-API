# Banco NotBank
RESTful API of the HealthSafe application, containing CRUD functionalities for doctors and patients, as well as appointment scheduling.

## Diagrama de Classes

``` mermaid
classDiagram
    class Address {
        -String street
        -String number
        -String city
        -String state
        -String zipCode
        +Address(AddressDto dto)
        +update(AddressDto dto)
    }

    class Patient {
        -Long id
        -String name
        -String email
        -String cpf
        -LocalDate birthDate
        -String phone
        -Address address
        +Patient(PatientCreateDto dto)
        +update(PatientUpdateDto dto)
    }

    class Doctor {
        -Long id
        -String name
        -String email
        -String crm
        -LocalDate birthDate
        -String phone
        -Speciality specialty
        -Address address
        +Doctor(DoctorCreateDto dto)
        +update(DoctorUpdateDto dto)
    }

    class Appointment {
        -Long id
        -Doctor doctor
        -Patient patient
        -LocalDateTime date
        +Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime date)
        +reschedule(AppointmentUpdateDto dto)
    }

    class PatientController {
        +create(PatientCreateDto dto)
        +findAll()
        +findById(Long id)
        +update(PatientUpdateDto dto)
    }

    class DoctorController {
        +create(DoctorCreateDto dto)
        +findAll()
        +findById(Long id)
        +update(DoctorUpdateDto dto)
    }

    class AppointmentController {
        +create(AppointmentCreateDto dto)
        +findById(Long id)
        +reschedule(AppointmentUpdateDto dto)
    }

    class PatientService {
        +create(PatientCreateDto dto)
        +findById(Long id)
        +findAll()
    }

    class DoctorService {
        +create(DoctorCreateDto dto)
        +findById(Long id)
        +findAll()
    }

    class AppointmentService {
        +create(AppointmentCreateDto dto)
        +findById(Long id)
        +findAll()
    }

    Address <-- Patient
    Address <-- Doctor
    Doctor <-- Appointment
    Patient <-- Appointment
    PatientController --> PatientService
    DoctorController --> DoctorService
    AppointmentController --> AppointmentService
    PatientService --> Patient
    DoctorService --> Doctor
    AppointmentService --> Appointment
    AppointmentService --> Doctor
    AppointmentService --> Patient
```
