package HealthSafe.controller;

import HealthSafe.domain.model.doctor.DoctorDetailsDto;
import HealthSafe.domain.model.doctor.DoctorUpdateDto;
import HealthSafe.domain.model.doctor.Doctor;
import HealthSafe.domain.model.doctor.DoctorCreateDto;
import HealthSafe.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody DoctorCreateDto dto) {
        var doctorCreated = doctorService.create(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/doctors/{id}")
                .buildAndExpand(doctorCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(new DoctorDetailsDto(doctorCreated));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> findAll(){
        var doctorList = doctorService.findAll();
        return ResponseEntity.ok(doctorList);
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var doctorAdded = doctorService.findById(id);
        return ResponseEntity.ok(new DoctorDetailsDto(doctorAdded));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateDto dto){
        var doctorToUpdate = doctorService.findById(dto.id());
        doctorToUpdate.update(dto);
        return ResponseEntity.ok(new DoctorDetailsDto(doctorToUpdate));
    }


}

