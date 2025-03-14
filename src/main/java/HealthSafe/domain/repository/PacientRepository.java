package HealthSafe.domain.repository;

import HealthSafe.domain.model.pacient.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {
}
