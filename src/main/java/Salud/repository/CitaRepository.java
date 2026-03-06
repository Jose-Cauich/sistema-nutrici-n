package Salud.repository;

import Salud.entity.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<CitasEntity, Long> {
    List<CitasEntity> findByPatient_IdPaciente(Long IdPaciente);
}
