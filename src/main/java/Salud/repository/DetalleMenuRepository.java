package Salud.repository;

import Salud.entity.DetallesMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMenuRepository extends JpaRepository<DetallesMenuEntity, Long> {

}
