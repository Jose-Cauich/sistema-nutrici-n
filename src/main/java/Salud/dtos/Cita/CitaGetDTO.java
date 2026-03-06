package Salud.dtos.Cita;

import Salud.enums.EstadoCita;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CitaGetDTO {

    private Long idCita;
    private String Nombrepaciente;
    private String NombreNutriologa;
    private String NombreTipoCita;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String estadoCita;
}