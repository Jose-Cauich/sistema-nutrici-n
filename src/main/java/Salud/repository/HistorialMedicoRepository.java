package Salud.repository;

import Salud.entity.HistorialClinicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialMedicoRepository extends JpaRepository<HistorialClinicoEntity, Long> {
}
