package HealthSafe.service;

import HealthSafe.domain.model.appointment.Appointment;
import HealthSafe.domain.model.appointment.AppointmentCreateDto;
import HealthSafe.domain.model.appointment.AppointmentDetailsDto;
import HealthSafe.domain.model.doctor.Doctor;
import HealthSafe.domain.repository.AppointmentRepository;
import HealthSafe.domain.repository.DoctorRepository;
import HealthSafe.domain.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PacientRepository pacientRepository;


    public AppointmentDetailsDto create(AppointmentCreateDto dto){
        if (!pacientRepository.existsById(dto.idPacient())){
            throw new IllegalArgumentException("Pacient is already registered");
        }
        if (dto.idDoctor() != null && !doctorRepository.existsById(dto.idDoctor())){
            throw new IllegalArgumentException("Doctor's ID does not exists");
        }
        var pacient = pacientRepository.getReferenceById(dto.idPacient());
        var doctor = doctorRepository.getReferenceById(dto.idDoctor());

        var appointment = new Appointment(null, doctor, pacient, dto.date());
        appointmentRepository.save(appointment);

        return new AppointmentDetailsDto(appointment);
    }

    public Appointment findById(Long id){
        return appointmentRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }


    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
}

