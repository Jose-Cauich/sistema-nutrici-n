package Salud.dtos.Cita;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaPostDTO {
    private Long idPaciente;
    private Long idNutriologa;
    private Long idTipoCita;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
