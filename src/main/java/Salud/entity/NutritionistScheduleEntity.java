package Salud.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

@Entity
@Table(name = "horarionutriologo")
@Data
public class NutritionistScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHorario")
    private Long idHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologo", nullable = false)
    private NutritionistEntity idNutriologo;

    @Column(name = "DiaSemana")
    private Integer diaSemana;

    @Column(name = "HoraInicio")
    private LocalTime horaInicio;

    @Column(name = "HoraFin")
    private LocalTime horaFin;
}