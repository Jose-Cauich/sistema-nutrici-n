package Salud.entity;

import Salud.enums.NombreRol;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
    private Long idRol;

    @Column(name = "nombre", columnDefinition = "text")
    private NombreRol nombreRol ;

}