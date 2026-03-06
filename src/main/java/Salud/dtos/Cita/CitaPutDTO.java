package Salud.dtos.Cita;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaPutDTO {
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estadoCita;
}