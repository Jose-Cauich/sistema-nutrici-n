package Salud.repository;

import Salud.entity.HistorialClinicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialClinicoRepository extends JpaRepository<HistorialClinicoEntity, Long> {

    List<HistorialClinicoEntity> findByPaciente_IdPaciente(Long IdPaciente);

}
