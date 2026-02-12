package Salud.repository;

import Salud.entity.MenuDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDetailRepository extends JpaRepository<MenuDetailEntity, Long> {

}
