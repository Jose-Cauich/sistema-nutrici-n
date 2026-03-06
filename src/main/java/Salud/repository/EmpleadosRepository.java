package Salud.repository;

import Salud.entity.EmpleadosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<EmpleadosEntity, Long> {
}
