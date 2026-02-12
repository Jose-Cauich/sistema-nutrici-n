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

    //los demas datos los extrae de el registro de user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPaciente")
    private Long idPaciente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdUsuario", unique = true)
    private UserEntity idUsuario;

    @CreationTimestamp
    @Column(name = "FechaRegistro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "Activo", nullable = false)
    private boolean activo = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologoAsignado")
    private NutritionistEntity idNutriologoAsignado;

}