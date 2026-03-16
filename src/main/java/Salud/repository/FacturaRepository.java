package Salud.repository;

import Salud.entity.FacturasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<FacturasEntity, Long> {

    Optional<FacturasEntity> findByPago_IdPago (Long idPago);
}
