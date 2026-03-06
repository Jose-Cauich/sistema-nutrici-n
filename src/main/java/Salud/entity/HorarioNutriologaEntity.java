package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "horarionutriologo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioNutriologaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHorario")
    private Long idHorario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologa", nullable = false)
    private NutriologasEntity idNutriologa;

    @Column(name = "DiaSemana")
    private Integer diaSemana;

    @Column(name = "HoraInicio")
    private LocalTime horaInicio;

    @Column(name = "HoraFin")
    private LocalTime horaFin;

    @Column(name = "activo")
    private String activo;
}