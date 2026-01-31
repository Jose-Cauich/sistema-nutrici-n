package Salud.dtos.NutritionistSchedule;

import lombok.Data;

import java.time.LocalTime;

@Data
public class NutritionistSchedulePostDTO {
    private Long idNutriologo;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalTime hora;
}