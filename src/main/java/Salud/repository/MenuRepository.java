package Salud.repository;

import Salud.entity.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenusEntity, Long> {

    //findBy + campo en Menu  + campo en Paciente
    List<MenusEntity> findByPaciente_IdPaciente(Long idPaciente);

}
