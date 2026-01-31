package Salud.dtos.Appointment;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AppointmentPostDTO {
    private Long idPaciente;
    private Long idNutriologo;
    private Long idTipoCita;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estadoCita;
}
