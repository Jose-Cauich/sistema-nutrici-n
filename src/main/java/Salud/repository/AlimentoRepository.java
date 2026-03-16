package Salud.repository;

import Salud.entity.AlimentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<AlimentosEntity, Long> {
}
