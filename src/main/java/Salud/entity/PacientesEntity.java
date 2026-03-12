package Salud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Salud.enums.Genero;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class PacientesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPaciente")
    private Long idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologa", nullable = false)
    private NutriologasEntity nutriologa;

    @Column(name = "Nombres", nullable = false, columnDefinition = "text")
    public String nombres;

    @Column(name = "ApellidoPaterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", nullable = false, columnDefinition = "text")
    private String apellidoMaterno;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genero")
    private Genero genero;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "Correo", nullable = false, unique = true, columnDefinition = "text")
    private String correo;

    @Column(name = "PasswordHash", unique = true, columnDefinition = "text")
    private String passwordHash;

    //yo guardo la direccion
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDireccion")
    private DireccionesEntity direccion;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @CreationTimestamp
    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private boolean activo;

}