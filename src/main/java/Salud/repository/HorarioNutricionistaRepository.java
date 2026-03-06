package Salud.repository;

import Salud.entity.HorarioNutriologaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioNutricionistaRepository extends JpaRepository<HorarioNutriologaEntity, Long> {
}
