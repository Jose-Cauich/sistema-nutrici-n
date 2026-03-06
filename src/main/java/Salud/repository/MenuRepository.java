package Salud.repository;

import Salud.entity.MenusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenusEntity, Long> {
}
