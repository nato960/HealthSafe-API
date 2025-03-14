package HealthSafe.service;

import HealthSafe.domain.model.doctor.Doctor;
import HealthSafe.domain.model.doctor.DoctorCreateDto;
import HealthSafe.domain.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create(DoctorCreateDto dto) {
        var doctor = new Doctor(dto);

        return doctorRepository.save(doctor);
    }

    public Doctor findById(Long id){
        return doctorRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }


    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
