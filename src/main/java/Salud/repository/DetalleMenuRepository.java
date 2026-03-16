package Salud.repository;

import Salud.dtos.DetallesMenu.DetallesMenuGetDTO;
import Salud.entity.DetallesMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleMenuRepository extends JpaRepository<DetallesMenuEntity, Long> {

    List<DetallesMenuEntity> findByMenu_IdMenu(Long idMenu);

}
