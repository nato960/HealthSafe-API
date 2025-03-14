package HealthSafe.service;

import HealthSafe.domain.model.doctor.Doctor;
import HealthSafe.domain.model.doctor.DoctorCreateDto;
import HealthSafe.domain.model.pacient.Pacient;
import HealthSafe.domain.model.pacient.PacientCreateDto;
import HealthSafe.domain.model.pacient.PacientUpdateDto;
import HealthSafe.domain.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PacientService {

    @Autowired
    private PacientRepository pacientRepository;


    public Pacient create(PacientCreateDto dto) {
        var pacient = new Pacient(dto);

        return pacientRepository.save(pacient);
    }

    public Pacient findById(Long id){
        return pacientRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }


    public List<Pacient> findAll() {
        return pacientRepository.findAll();
    }

}


