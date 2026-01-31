package Salud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDetailRepository extends JpaRepository<MenuDetailRepository, Long> {

}
