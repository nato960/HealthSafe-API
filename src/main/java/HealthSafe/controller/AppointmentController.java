package HealthSafe.controller;

import HealthSafe.domain.model.appointment.AppointmentCreateDto;
import HealthSafe.domain.model.appointment.AppointmentDetailsDto;
import HealthSafe.domain.model.appointment.AppointmentUpdateDto;
import HealthSafe.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody AppointmentCreateDto dto) {
        var appointmentCreated = appointmentService.create(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/appointments/{id}")
                .buildAndExpand(appointmentCreated.id())
                .toUri();

        return ResponseEntity.created(location).body(appointmentCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        var appointmentAdded = appointmentService.findById(id);
        return ResponseEntity.ok(new AppointmentDetailsDto(appointmentAdded));
    }

    @PutMapping
    @Transactional
    public ResponseEntity reschedule(@RequestBody @Valid AppointmentUpdateDto dto){
        var appointmentToUpdate = appointmentService.findById(dto.id());
        appointmentToUpdate.reschedule(dto);
        return ResponseEntity.ok(new AppointmentDetailsDto(appointmentToUpdate));
    }


}
