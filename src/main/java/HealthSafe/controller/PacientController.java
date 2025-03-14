package HealthSafe.controller;

import HealthSafe.domain.model.pacient.Pacient;
import HealthSafe.domain.model.pacient.PacientCreateDto;
import HealthSafe.domain.model.pacient.PacientDetailsDto;
import HealthSafe.domain.model.pacient.PacientUpdateDto;
import HealthSafe.service.PacientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pacients")
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody PacientCreateDto dto) {
        var pacientCreated = pacientService.create(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/pacients/{id}")
                .buildAndExpand(pacientCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(new PacientDetailsDto(pacientCreated));
    }

    @GetMapping
    public ResponseEntity<List<Pacient>> findAll(){
        var pacientList = pacientService.findAll();
        return ResponseEntity.ok(pacientList);
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var pacientAdded = pacientService.findById(id);
        return ResponseEntity.ok(new PacientDetailsDto(pacientAdded));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid PacientUpdateDto dto){
        var pacientToUpdate = pacientService.findById(dto.id());
        pacientToUpdate.update(dto);
        return ResponseEntity.ok(new PacientDetailsDto(pacientToUpdate));
    }

}
