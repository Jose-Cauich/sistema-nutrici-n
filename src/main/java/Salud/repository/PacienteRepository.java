package Salud.repository;

import Salud.entity.PacientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacientesEntity, Long> {

}
