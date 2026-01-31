package Salud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistScheduleRepository extends JpaRepository<NutritionistScheduleRepository, Long> {
}
