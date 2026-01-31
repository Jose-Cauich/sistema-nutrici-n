package Salud.repository;

import Salud.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<MedicalHistoryRepository, Long> {

    Optional<RolEntity> findByNombre(String nombre);
}
