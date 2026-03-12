package Salud.entity;

import Salud.enums.EstadoCita;
import Salud.enums.NombreRol;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class EmpleadosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdEmpleados")
    private Long idEmpleados;

    @Column(name = "Nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "ApellidoPaterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "FechaNacimiento", updatable = false)
    private LocalDateTime fechaNacimiento;

    @Column(name = "Telefono", length = 10)
    private String telefono;

    @Column(name = "Correo", columnDefinition = "text")
    private String correo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDireccion")
    private DireccionesEntity direccion;

    @Column(name = "PasswordHash", unique = true, columnDefinition = "text")
    private String passwordHash;

    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private Boolean activo;

    //Rol
    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", nullable = false)
    private NombreRol rol;

}