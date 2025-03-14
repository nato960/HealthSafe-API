package HealthSafe.domain.model.appointment;

import HealthSafe.domain.model.doctor.Doctor;
import HealthSafe.domain.model.doctor.DoctorUpdateDto;
import HealthSafe.domain.model.pacient.Pacient;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "tb_appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    private LocalDateTime date;

    public Appointment() {}

    public Appointment(Long id, Doctor doctor, Pacient pacient, LocalDateTime date) {
        this.id = id;
        this.doctor = doctor;
        this.pacient = pacient;
        this.date = date;
    }

    public void reschedule(AppointmentUpdateDto dto) {
        if (dto.date() != null) {
            this.date = dto.date();
        }
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Pacient getPacient() {
        return pacient;
    }
}

