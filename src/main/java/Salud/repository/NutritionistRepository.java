package Salud.repository;

import Salud.entity.NutritionistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionistRepository extends JpaRepository<NutritionistEntity, Long> {
}
