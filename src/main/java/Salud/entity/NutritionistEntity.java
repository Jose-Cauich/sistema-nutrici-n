package Salud.entity;

import Salud.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "nutriologo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NutritionistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdNutriologo")
    private Long idNutriologo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", nullable = false, unique = true)
    private UserEntity idUsuario;

    @Column(name = "Nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "ApellidoPaterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "CedulaProfesional", nullable = false, unique = true, columnDefinition = "text")
    private String cedulaProfesional;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genero", nullable = false)
    private Gender genero;

    @Column(name = "Telefono", length = 10)
    private String telefono;

    @Column(name = "Correo", columnDefinition = "text")
    private String correo;

    @Column(name = "Direccion", columnDefinition = "text")
    private String direccion;

    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private Boolean activo = true;
}