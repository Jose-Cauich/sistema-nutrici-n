package Salud.entity;

import Salud.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private Long idUsuario;

    @Column(name = "Nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "ApellidoPaterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", nullable = false, columnDefinition = "text")
    private String apellidoMaterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genero")
    private Gender genero;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Correo", nullable = false, unique = true, columnDefinition = "text")
    private String correo;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "DireccionUsuario", nullable = false, columnDefinition = "text")
    private DirectionUserEntity direccion;

    @CreationTimestamp
    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private boolean activo = true;

    @OneToOne
    @JoinColumn(name = "IdRol", nullable = false)
    private RolEntity rol;

    @OneToOne
    @JoinColumn(name = "id_password")
    private PasswordEntity password;

}