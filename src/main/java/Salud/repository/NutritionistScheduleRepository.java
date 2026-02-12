package Salud.repository;

import Salud.entity.NutritionistScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistScheduleRepository extends JpaRepository<NutritionistScheduleEntity, Long> {
}
