package Salud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Salud.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "paciente")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPaciente")
    private Long idPaciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", unique = true)
    private UserEntity idUsuario;

    @Column(name = "Nombres", nullable = false, columnDefinition = "text")
    private String nombres;

    @Column(name = "ApellidoPaterno", nullable = false, columnDefinition = "text")
    private String apellidoPaterno;

    @Column(name = "ApellidoMaterno", columnDefinition = "text")
    private String apellidoMaterno;

    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "Genero")
    private Gender genero;

    @Column(name = "Telefono", length = 10)
    private String telefono;

    @Column(name = "Correo", columnDefinition = "text")
    private String correo;

    @Column(name = "Direccion", nullable = false, columnDefinition = "text")
    private String direccion;

    @CreationTimestamp
    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private boolean activo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologoAsignado")
    private NutritionistEntity idNutriologoAsignado;

}