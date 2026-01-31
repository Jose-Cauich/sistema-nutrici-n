package Salud.entity;

import Salud.enums.StateAppointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCita")
    private Long idCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    private PatientEntity idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologo", nullable = false)
    private NutritionistEntity idNutriologo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdTipoCita", nullable = false)
    private AppointmentTypeEntity idTipoCita;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "HoraInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HoraFin", nullable = false)
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoCita", nullable = false)
    private StateAppointment estadoCita;



}