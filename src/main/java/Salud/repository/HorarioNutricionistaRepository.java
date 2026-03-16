package Salud.repository;

import Salud.entity.HorarioNutriologaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioNutricionistaRepository extends JpaRepository<HorarioNutriologaEntity, Long> {

    List<HorarioNutriologaEntity> findByNutriologa_IdNutriologa(Long idNutriologa);


}
