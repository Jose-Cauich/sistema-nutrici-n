package Salud.repository;

import Salud.entity.TipoCitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCitaRepository extends JpaRepository<TipoCitasEntity, Long> {
}
