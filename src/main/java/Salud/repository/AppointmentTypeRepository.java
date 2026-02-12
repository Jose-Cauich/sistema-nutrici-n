package Salud.repository;

import Salud.entity.AppointmentEntity;
import Salud.entity.AppointmentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentTypeRepository extends JpaRepository<AppointmentTypeEntity, Long> {
}
