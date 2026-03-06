package Salud.entity;

import Salud.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cita")
public class CitasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCita")
    private Long idCita;

    //Relacion con T.Pacientes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    private PacientesEntity Paciente;

    //Relacion con T.Nutriologa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologa", nullable = false)
    private NutriologasEntity Nutriologa;

    //Relacion con T.TipoCita
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoCita", nullable = false)
    private TipoCitasEntity TipoCita;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "HoraInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HoraFin", nullable = false)
    private LocalTime horaFin;

    //Relacion Enums
    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoCita", nullable = false)
    private EstadoCita estadoCita;



}